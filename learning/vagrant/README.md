

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
ansible-control

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

ssh-copy-id -i /Users/longhoangphan/.ssh/id_ed25519 vagrant@192.168.201.12
sudo vagrant ssh-config | grep IdentityFile

ansible-playbook -i host playbook.yml
ansible all -i host --limit node01 -a "/bin/echo hello"

