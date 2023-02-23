pipeline {
    agent any
    tools {
        maven 'maven_3_9_0'
    }

    stages {
        stage('Build Maven Project') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/shimawe/spring-jenkins']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t zhenekns/devops-integration .'
                }
            }
        }
        stage('Push image to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u zhenekns -p ${dockerhubpwd}'
                    }
                    sh 'docker push zhenekns/devops-integration'
                }
            }
        }
    }
}