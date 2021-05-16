pipeline {
    agent any
	    
   tools
    {
       maven "Maven-3.8.1"
    }
   
   stages {
      
	
	
	stage('test & package') {
           steps {
             
                bat 'mvn install'             
          }
        }
        

       stage('Build image and tag') {
           steps {
              
                bat 'docker build -t spring-jenkins-docker-app .' 
                bat 'docker tag spring-boot-actuator 31393/spring-jenkins-docker-app:1.0.1'
               
          }
        }
      
        stage('Publish image') {
          
            steps {
        withDockerRegistry([ credentialsId: "Docker-Credentials", url: "" ]) {
              bat 'docker push 31393/spring-jenkins-docker-app:1.0.1'
        }
                  
          }
        }
     
        stage('Run Docker container on Jenkins Agent') {
             
            steps {
                bat "docker run -d -p 8003:8080 31393/spring-jenkins-docker-app:1.0.1"
 
            }
        }
    }
     post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
    
}
