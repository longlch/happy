output "ip" {
  value = google_compute_instance.vm_instance.network_interface.0.network_ip
}

output "network-name" {
  value = google_compute_instance.vm_instance.network_interface.0.name
}

output "instance_id" {
  value = google_compute_instance.vm_instance.instance_id
}

output "boot_disk" {
  value = google_compute_instance.vm_instance.boot_disk.0.device_name
}