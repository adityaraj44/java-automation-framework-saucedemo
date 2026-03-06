pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/adityaraj44/java-automation-framework-saucedemo.git'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                bat 'docker compose up -d'
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
