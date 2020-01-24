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
    stage('Build') {
      steps {
        sh "mvn clean"
      }
    }
    stage('Test') {
      steps {
        sh "mvn test"
      }
    }
  }
  tools {
    maven 'maven 3.6.2'
    jdk 'JDK11'
  }
}