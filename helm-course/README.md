helm create webapp1

helm install first-release webapp1

kubectl get all

helm stop

#
kubectl delete deployments --all
kubectl delete services --all

minikube service <SERVICE_NAME>

# upgrade

helm upgrade first-release webapp1/ --values ./webapp1/values.yaml
helm ls 

kubectl port-forward svc/myhelmapp 8888:80

# Create namespace
kubectl create namespace dev
kubectl create namespace prod

helm install first-release-dev webapp1/ --values ./webapp1/values.yaml -f ./webapp1/values-dev.yaml -n dev
helm install first-release-prod webapp1/ --values ./webapp1/values.yaml -f ./webapp1/values-prod.yaml -n prod

helm upgrade first-release-dev webapp1
