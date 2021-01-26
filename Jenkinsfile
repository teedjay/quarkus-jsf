pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
      }
    }
     stage('Run tests') {
       steps {
         sh "mvn clean test"
       }
     }
  }
  post {
    always {
        junit 'target/target/surefire-reports/*.xml'
    }
  }
  tools {
    maven 'maven 3.6.2'
    jdk 'JDK11'
  }
}
