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