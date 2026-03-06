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
                sh 'docker compose up -d'
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
            sh 'docker compose down'
        }
    }
}
