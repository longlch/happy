pipeline {
    agent any
    environment {
        CLOUDSDK_CORE_PROJECT='happy-427410'
        GCLOUD_CREDS=credentials('gcloud-creds')
    }
    stages {
        stage('test') {
            steps {
                sh '''
          gcloud version
          gcloud auth activate-service-account --key-file="$GCLOUD_CREDS"
          gcloud compute zones list
        '''
            }
        }
    }
}