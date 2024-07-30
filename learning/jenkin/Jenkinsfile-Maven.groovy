pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/longlch/simple-java-maven-app'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTest -Ddependency-check.skip=true -Dmaven.test.skip'
            }
        }
    }
}
