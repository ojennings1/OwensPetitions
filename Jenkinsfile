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
                input message: 'Deploy to EC2?'
                sshagent(['ec2-key']) {
                    sh '''
                        scp target/owenspetitions.war ubuntu@100.24.240.180:/home/ubuntu/
                        ssh ubuntu@100.24.240.180 "sudo rm -rf /var/lib/tomcat10/webapps/owenspetitions"
                        ssh ubuntu@100.24.240.180 "sudo cp /home/ubuntu/owenspetitions.war /var/lib/tomcat10/webapps/"
                        ssh ubuntu@100.24.240.180 "sudo systemctl restart tomcat10"
                    '''
                }
            }
        }
    }
}
