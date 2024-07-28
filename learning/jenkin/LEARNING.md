# Install gcloud in docker image
https://stackoverflow.com/questions/28372328/how-to-install-the-google-cloud-sdk-in-a-docker-image

# Integrate Gcloud to Jenkin
7C7hnSnWvCDYXzMAsdpVe1EAVpyQe

def jobName = "gloud"
def job = Jenkins.instance.getItem(jobName)
job.getBuilds().each { it.delete() }
job.nextBuildNumber = 1
job.save()



gcloud auth configure-docker asia-east1-docker.pkg.dev

gcloud auth activate-service-account --key-file="/Users/longhoangphan/project/longlch/happy/learning/jenkin/happy-427410-8bf45eac92f5.json"

docker push asia-east1-docker.pkg.dev/happy-427410/happy-dev/sample-node-v1
gcloud auth configure-docker asia-east1-docker.pkg.dev