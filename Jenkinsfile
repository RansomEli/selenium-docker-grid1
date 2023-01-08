pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                // for Mac: sh, for Windows: use bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='ransomeli/selenium-docker2' ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    sh 'docker login --username=${user} --password=${pass}'
                    sh 'docker push ransomeli/selenium-docker2:latest'
                }
            }
        }
    }
}