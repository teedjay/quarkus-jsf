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
     stage('Create HTML reports') {
       steps {
         sh "mvn surefire-report:report"
       }
     }
  }
  post {
    always {
        junit 'target/surefire-reports/*.xml'
    }
  }
  tools {
    maven 'maven 3.6.2'
    jdk 'JDK11'
  }
}
