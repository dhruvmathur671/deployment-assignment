pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/dhruvmathur671/deployment-assignment.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }

        stage('SonarQube analysis') {
            steps {
                sh 'mv target/assignment-0.0.1-SNAPSHOT.jar my-app.jar'
                script {
                    // requires SonarQube Scanner 2.8+
                    scannerHome = tool 'SonarQube Scanner 2.8'
                }
                withSonarQubeEnv('SonarQube Scanner') {
                    sh "mvn clean package sonar:sonar"
                    sleep 60 
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('SSH transfer') {
          steps {
            sshPublisher(
                continueOnError: false, failOnError: true,
                publishers: [
                    sshPublisherDesc(
                        configName: "dev1",
                        verbose: true,
                        transfers: [
                            sshTransfer(sourceFiles: "my-app.jar")
                        ],

                    )
                ]
            )
        
            }
            
        } 
    }

}
