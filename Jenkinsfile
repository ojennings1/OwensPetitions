pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ojennings1/OwensPetitions.git'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean compile"
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

        // Run the JAR in background so Jenkins doesn’t hang as has been happening
        stage('Run') {
            steps {
                sh "nohup java -jar target/OwensPetitions-1.0-SNAPSHOT.jar &"
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
