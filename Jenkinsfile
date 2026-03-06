pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Start Grid') {
            steps {
                bat 'docker compose up -d --scale chrome=8 --scale firefox=8'
                bat 'ping -n 10 127.0.0.1 >nul'
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
            bat 'docker compose down'
        }
    }
}
