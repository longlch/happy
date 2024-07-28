pipeline {
    agent any

    tools {
        nodejs 'nodejs' // Name of the NodeJS installation
    }
    environment {
        CLOUDSDK_CORE_PROJECT='happy-427410'
        PROJECT='happy-427410'
        REPOSITORY='happy-dev'
        GCLOUD_CREDS=credentials('gcloud-creds')
        IMAGE_NAME = 'sample-node-v2'
        FINAL_IMAGE_NAME = 'sample-node-v2:latest'
        IMAGE_TAG = 'latest'
        LOCATION = 'asia-east1-docker.pkg.dev'
        ARTIFACT_REGISTRY = "${LOCATION}/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}" // Corrected line

    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/longlch/sample-node-project.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Authenticate') {
            steps {
                sh '''
                    gcloud auth activate-service-account --key-file="$GCLOUD_CREDS"
                    gcloud auth configure-docker ${LOCATION}
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${FINAL_IMAGE_NAME}")
                }
            }
        }

        stage('Push to Google Cloud Registry') {
            steps {
                script {
                    sh '''
                        docker tag ${FINAL_IMAGE_NAME} ${ARTIFACT_REGISTRY}
                        docker push ${ARTIFACT_REGISTRY}
                    '''
                }
            }
        }
    }

//    post {
//        always {
//            cleanWs()
//        }
//        success {
//            echo 'The build and push succeeded!'
//        }
//        failure {
//            echo 'The build or push failed.'
//        }
//    }
}
