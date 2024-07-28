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
        IMAGE_TAG = 'latest'
        LOCATION = 'asia-east1-docker.pkg.dev'
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
                    gcloud auth configure-docker $LOCATION
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Push to Google Cloud Registry') {
            steps {
                script {
                    sh '''
                        docker tag ${IMAGE_NAME}:${IMAGE_TAG} asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}
                        docker push asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}
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
