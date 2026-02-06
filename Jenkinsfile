pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t spring-crud-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker rm -f spring-app || true
                docker run -d -p 8081:8080 --name spring-app spring-crud-app
                '''
            }
        }
    }
}

