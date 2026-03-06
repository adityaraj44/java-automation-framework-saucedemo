pipeline {
    agent any

    stages {

        stage('Start Selenium Grid') {
            steps {
                bat 'docker compose up -d'
                bat 'timeout /t 15'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
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
