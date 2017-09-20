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
        wrappers {
            injectPasswords {
                injectGlobalPasswords()
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
      }'''
    }
}