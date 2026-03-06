pipeline {
    agent any

    stages {

        stage('Start Grid') {
            steps {
                bat 'docker compose up -d'
                bat 'ping -n 20 127.0.0.1 >nul'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Stop Grid') {
            steps {
                bat 'docker compose down'
            }
        }

    }
}
