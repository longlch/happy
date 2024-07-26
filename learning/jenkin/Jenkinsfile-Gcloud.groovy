pipeline {
    agent any

    tools {
        nodejs 'nodejs' // Name of the NodeJS installation
    }
    environment {
        CLOUDSDK_CORE_PROJECT='happy-427410'
        GCLOUD_CREDS=credentials('gcloud-creds')
        IMAGE_NAME = 'sample-node'
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

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('test') {
            steps {
                sh '''
                    echo "hello world" > hello.txt
                    gcloud version
                    gcloud auth activate-service-account --key-file="$GCLOUD_CREDS"
                    gcloud compute zones list
                '''
            }
        }
    }
}