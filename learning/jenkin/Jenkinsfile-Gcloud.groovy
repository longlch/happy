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
                    echo "hello world" > hello.txt
                    gcloud version
                    gcloud auth activate-service-account --key-file="$GCLOUD_CREDS"
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    app = docker.build("asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Push to Google Cloud Registry') {
            steps {
                script {
                    sh 'gcloud auth configure-docker asia-east1-docker.pkg.dev'
                    sh 'docker push asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}'

//                    withDockerRegistry([credentialsId: 'gcloud-creds', url: "https://asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}"]) {
//                        sh 'docker tag ${IMAGE_NAME}:${IMAGE_TAG} asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}'
//                        sh 'docker push asia-east1-docker.pkg.dev/${PROJECT}/${REPOSITORY}/${IMAGE_NAME}:${IMAGE_TAG}'
//                    }

//                    docker.withRegistry('https://eu.gcr.io', 'gcr:gcloud-creds') {
//                        app.push("${env.BUILD_NUMBER}")
//                        app.push("latest")
//                    }
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
