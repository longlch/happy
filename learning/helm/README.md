# Command
`helm create <YOUR_FOLDER>`
ex: `helm create webapp1`

# Local environtment
`helm install release1 webapp1`
`helm upgrade release1 webapp1 --values webapp1/values.yaml`


# Dev environtment
`helm install release1 webapp1 --values webapp1/values-dev.yaml -n dev`
`helm upgrade release1 webapp1 --values webapp1/values-dev.yaml -n dev`