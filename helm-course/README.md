helm create webapp1

helm install first-release webapp1

kubectl get all

helm stop

kubectl delete deployments --all
kubectl delete services --all

minikube service <SERVICE_NAME>