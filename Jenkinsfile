pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage('checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch:'master',url:'https://github.com/dhruvmathur671/deployment-assignment.git'

                // Run Maven on a Unix agent.

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }

        stage('SonarQube analysis') {
            steps
                    {
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
        
        stage("build") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('SSH transfer') {
          steps([$class: 'BapSshPromotionPublisherPlugin']) {
            sshPublisher(
                continueOnError: false, failOnError: true,
                publishers: [
                    sshPublisherDesc(
                        configName: "dev1",
                        verbose: true,
                        transfers: [
                            sshTransfer(sourceFiles: "**/*.jar",removePrefix:"",
                                    remoteDirectory:"",
                                    execCommand:"java -jar **/*.jar")
                        ],

                    )
                ]
            )
        
            }
            
        } 
    }

}
