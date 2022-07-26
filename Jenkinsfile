pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh - bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh   - bat
                sh "docker build -t='ransomeli/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub',
			                                      passwordVariable: 'pass',
			                                      usernameVariable: 'user')]) {
                    //sh  - bat
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push ransomeli/selenium-docker:latest"
			    }
            }
        }
    }
}