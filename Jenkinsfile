node {
    try {
         stage('checkout') {
            git 'https://github.com/Gnanapandithan/test-app.git'
            def pom = readMavenPom file: 'pom.xml'
            echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@${pom}"   
            def i = pom.version.indexOf("-SNA")
            def version = pom.version.substring(0,i)
            echo "##########################${pom.version}"
            echo "?????????????????????${version}"
            currentBuild.displayName = "#" +version
         }
        stage('build') {
            bat 'mvn clean release:clean release:prepare release:perform'
                
                def userInput = input(
             id: 'userInput', message: 'Let\'s promote?', parameters: [
             [$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env'],
             [$class: 'TextParameterDefinition', defaultValue: 'uat1', description: 'Target', name: 'target']
            ])
            echo ("Env: "+userInput['env'])
            echo ("Target: "+userInput['target'])
        }
        stage('archival') {
            archiveArtifacts 'target/*.war'
        }
        stage ('Promotion') {
            timeout(time: 1, unit: 'HOURS') {
            input 'Deploy to Production?'
        }
  }

        
    }catch(err) {
        echo " Error $err"
        currentBuild.result = 'FAILURE'
    }
}
