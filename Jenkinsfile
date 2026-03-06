pipeline {
    agent any

    stages {

        stage('Start Grid') {
            steps {
                bat 'docker compose up -d'
                bat 'timeout /t 20'
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
