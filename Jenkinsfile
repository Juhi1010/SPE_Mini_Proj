
pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = 'juhir10'   // Your Docker Hub username
        DOCKER_IMAGE = 'spe-mini'     // Docker image name
        DOCKER_TAG = 'latest'         // Image tag
    }

    triggers {
        githubPush()  // Enables GitHub Webhook Trigger
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Juhi1010/SPE_Mini_Proj.git' // Replace with your repo
            }
        }

        stage('Run JUnit Tests') {
            steps {
                sh './mvnw test'  // Runs JUnit tests using Maven Wrapper
            }
        }

        stage('Build JAR') {
                    steps {
                        sh './mvnw clean package'  // Builds the JAR file inside 'target' directory
                    }
                }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t $DOCKER_HUB_USER/$DOCKER_IMAGE:$DOCKER_TAG .
                '''
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'docker-hub-password', variable: 'DOCKER_PASSWORD')]) {
                    sh '''
                    echo $DOCKER_PASSWORD | docker login -u $DOCKER_HUB_USER --password-stdin
                    '''
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh '''
                docker push $DOCKER_HUB_USER/$DOCKER_IMAGE:$DOCKER_TAG
                '''
            }
        }

//         stage('Deploy with Ansible') {
//             steps {
//                 sh '''
//                 cd ansible
//                 ansible-playbook -i inventory deploy.yml
//                 '''
//             }
//         }
//
        stage('Deploy with Ansible') {
            steps {
                sh '''
                docker stop spe-mini-cli || true
                docker rm spe-mini-cli || true
                cd ansible
                ansible-playbook -i hosts.ini deploy.yml
                '''
            }
        }

//         stage('Deploy Container') {
//             steps {
//                 sh '''
//                 docker stop spe-mini-container || true
//                 docker rm spe-mini-container || true
//                 docker run -d --name spe-mini-container $DOCKER_HUB_USER/$DOCKER_IMAGE:$DOCKER_TAG
//                 '''
//             }
//         }
    }

    post {
        always {
            echo "Pipeline execution finished!"
        }
    }
}
