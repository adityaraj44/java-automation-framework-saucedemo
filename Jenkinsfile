pipeline {
    agent any

    stages {

        stage('Start Selenium Grid') {
            steps {
                sh 'docker compose up -d'
                sh 'timeout /t 20'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

    }

    post {
        always {
            publishHTML([
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'HTML Report'
            ])
        }
    }
}
