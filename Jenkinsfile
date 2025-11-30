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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
                archiveArtifacts artifacts: 'target/owenspetitions.war', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    sudo rm -rf /var/lib/tomcat10/webapps/owenspetitions
                    sudo cp target/owenspetitions.war /var/lib/tomcat10/webapps/
                    sudo systemctl restart tomcat10
                '''
            }
        }
    }
}
