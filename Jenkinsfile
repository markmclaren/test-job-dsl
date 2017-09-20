node {
    stage('Create seed job') {
      jobDsl scriptText: '''job(\'seed-job\'){
        println("${BUILD_NUMBER}")
        scm {
            git {
                remote {
                    url(\'https://github.com/markmclaren/test-job-dsl\')
                }
           }
        }
        steps {
            gradle {
              tasks(\'libs\')
              useWrapper(false)
            }
            dsl {
               external \'**/*_jobdsl.groovy\'
               additionalClasspath \'lib/*.jar\'
            }
        }
        wrappers {
            credentialsBinding {
                string('SECRET_DECRYPTION_KEY', 'SECRET_DECRYPTION_KEY')
            }
        }
      }'''
    }
}