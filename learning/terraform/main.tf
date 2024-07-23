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
