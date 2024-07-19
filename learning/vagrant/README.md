

# setup Vagrant
https://devopscube.com/build-vms-mac-silicon-with-vagrant/

## setup base code
https://github.com/techiescamp/kubernetes-certification-guide

# create file
vagrant init bento/ubuntu-22.04


# ssh
sudo vagrant status
sudo vagrant ssh controlplane

# stop
sudo vagrant halt

ssh vagrant@192.168.201.10
password: vagrant


# reload
sudo vagrant reload

# start
sudo vagrant up

# destroy
sudo vagrant destroy

# suspend
sudo vagrant suspend

# resume
sudo vagrant resume

# reboot
sudo vagrant reboot

# restart
sudo vagrant restart


# Ansible Section
[control]
ansivle-control

[proxy]
loadbalancer

[webserver]
web01
web02

[database]
db01

[webstack:children]
proxy
webserver
database


--- Command
https://spacelift.io/blog/ansible-tutorial
- https://github.com/Imoustak/ansible_intro/tree/main
- https://dev.to/educative/ansible-for-beginners-get-started-with-it-automation-4mci#nextsteps

vargrant ssh-config
`copy IdentityFile and add to host file`

`ansible -i hosts all -m ping`

ssh-copy-id node01 && ssh-copy-id node02 

ssh-copy-id -i /Users/longhoangphan/.ssh/id_ed25519 vagrant@192.168.201.12

sudo vagrant ssh-config | grep IdentityFile

# note
Controlplane ssh key
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDgoRLcT+4TTzGRB/FXtIZwWNpFicH76Zjs80Y7EeIEXdczXbq83CuK0MCdgpqQZM8C/jDC6ysiYVvBsBD8nApvYrypikNC4OETrj+AEgwZYB8qhYV8KaXMX1+u7uUjksCP/tVRDkARt0Ri0Lm2bAbelSeCYHoAVT0n7YtdZ12hDlDTxAiNclBaTZ4zdHt5kqWrUBlori998DaibCEcEYjhTtBw7UnVU9WAuQdfVSolV8AxNW0X0HgHyE2cdwserB9jaXJoOP0TTXWoH02djWOrmn8qfTz0fFyyM5uMBylHl8kPAHHQ53AqzEq8A3U9+lmoAdSKww/HphzTI+C4AdGnt0VBoYYfnphS5i5t3D5XRhFkpf8hw7vT8tv9avLM7zygAYEfRmH2PADqmDZE1rXQ7N0RapsRMnHmliXMRLDLpENk0HOtm6TjUGGD1cv+hDXdFh6/qt4d6aH20YfGJyA2wOxJW16GT/U4uGec1WZNJRovk5YpqWzW8YAnn/7w8qU= vagrant@controlplane


[db]
192.168.201.11


ansible-playbook -i host playbook.yml