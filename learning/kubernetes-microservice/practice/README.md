## Follow this tutorial to deploy your first web app on Minikube

https://medium.com/@xcoulon/deploying-your-first-web-app-on-minikube-6e98d2884b3a

### Exercise:

- Create database
- Create shorten url app which interact with database
- Create service for Postgres and shorten url app
- Publish the endpoint so that it can be accessed from outside the cluster (in case is browser)

### Example:

- Create data to create url

```
curl -X POST http://localhost:31317/ -d "full_url=https://redhat.com"
```

- Get Data

```
curl -X GET http://localhost:8080/EZpNfRi -v
```

# Remove the following line

wget http://postgres-service.default.svc.cluster.local:5432

kubectl logs url-deployment-b4fd49d64-hx2kn

wget -O- 10.244.120.68:5432
wget -O- postgres-service

kubectl get pods
kubectl apply -f deployment-url-app.yaml
kubectl delete deployment url-deployment

kubectl apply -f deployment-postgres.yaml
kubectl delete -f deployment-postgres.yaml

___
kubectl apply -f deployment-postgres.yaml
kubectl apply -f busybox.yaml

kubectl get pods -o wide
kubectl exec -it busybox-54f785c7d7-7r7rk -- sh
kubectl exec -it alpine-postgres-test -- sh
PGPASSWORD=mysecretpassword psql -h postgres-service -U postgres -c "\l"

wget -O- 10.244.120.67:5432
wget -O- postgres-service.default.svc.cluster.local:5432

wget -O- 10.244.120.67
wget -O- postgres-service.default.svc.cluster.local

PGPASSWORD=mysecretpassword psql -h 10.244.120.67 -U user -c "\l"
PGPASSWORD=mysecretpassword psql -h postgres-service.default.svc.cluster.local -U user -d url_shortener_db -c "\l"
PGPASSWORD=mysecretpassword psql -h 10.244.120.67 -U user -d url_shortener_db -c "\l"
