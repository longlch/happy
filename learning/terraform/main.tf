terraform { //  including the required providers Terraform will use to provision your infrastructure
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "4.51.0"
    }
  }
}

provider "google" { // A provider is a plugin that Terraform uses to create and manage your resources
  project = "happy-427410"
}

resource "google_compute_network" "vpc_network" { // define components of your infrastructure.
  name = "terraform-network"
}

resource "google_compute_instance" "vm_instance" {
  name         = "terraform-instance"
  machine_type = "f1-micro"
  zone = "asia-east1-a"
  tags = ["web", "dev"]


  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-11"
    }
  }

  network_interface {
    network = google_compute_network.vpc_network.name
    access_config {
    }
  }
}

