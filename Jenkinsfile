pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                // for Mac: sh, for Windows: use bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                script {
                     app = docker.build("ransomeli/selenium-docker2")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }
}