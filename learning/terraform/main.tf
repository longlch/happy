terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.51.0"
    }
  }
}

provider "google" {
  project = "happy-427410"
}

resource "google_compute_network" "vpc_network" {
  name = "terraform-network"
}

resource "google_compute_instance" "vm_instance" {
  name         = "jenkin-instance"
  machine_type = "g1-small"
  zone = var.zone
  tags = ["web", "dev", "http-server"] # Add http-server tag

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-11"
    }
  }

  network_interface {
    network = google_compute_network.vpc_network.name
    access_config {
      # Enable external IP address for SSH access
      network_tier = "PREMIUM"
    }
  }
}

resource "google_compute_firewall" "ssh_firewall" {
  name    = "allow-ssh"
  network = google_compute_network.vpc_network.name
  allow {
    protocol = "tcp"
    ports    = ["22"]
  }
  source_ranges = ["0.0.0.0/0"] # Allow SSH from anywhere
  target_tags = ["web", "dev"] # Allow SSH to instances with these tags
}

resource "google_compute_firewall" "http_firewall" {
  name    = "allow-http"
  network = google_compute_network.vpc_network.name
  allow {
    protocol = "tcp"
    ports    = ["8080", "80"]
  }
  source_ranges = ["0.0.0.0/0"] # Allow HTTP from anywhere
  target_tags = ["web", "dev"] # Allow HTTP to instances with this tag
}