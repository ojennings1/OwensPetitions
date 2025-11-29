pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/ojennings1/OwensPetitions.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean package"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        stage('Run') {
            steps {
                sh "mvn exec:java"
            }
        }
    }
}