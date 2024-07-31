pipeline {
    agent any
    environment {
        CLOUDSDK_CORE_PROJECT = 'happy-427410'
        PROJECT = 'happy-427410'
        REPOSITORY = 'happy-dev'
        GCLOUD_CREDS = credentials('gcloud-creds') // Assuming you have a credential named 'gcloud-creds'
        IMAGE_NAME = 'sample-maven'
        FINAL_IMAGE_NAME = 'sample-maven:latest'
        IMAGE_TAG = 'latest'
        LOCATION = 'asia-east1-docker.pkg.dev'
        MAVEN_CENTRAL_ARTIFACT_REPO = 'quickstart-java-repo'
        GG_REGION = 'asia-east1'
        ARTIFACT_REGISTRY = "${LOCATION}/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}"

    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/longlch/simple-java-maven-app'
            }
        }

        stage('Build Maven dependency') {
            steps {
                sh 'mvn clean install -DskipTest -Ddependency-check.skip=true -Dmaven.test.skip'
            }
        }

        stage('Authenticate') {
            steps {
                // Authenticate with gcloud using the service account key
                sh '''
                    gcloud auth activate-service-account --key-file="$GCLOUD_CREDS"
                    gcloud auth configure-docker ${LOCATION}
                    export GOOGLE_APPLICATION_CREDENTIALS=${GCLOUD_CREDS}
                    mvn clean deploy
                '''
                // Configure Maven to use the Artifact Registry
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            echo 'The build and push succeeded!'
        }
        failure {
            echo 'The build or push failed.'
        }
    }
}