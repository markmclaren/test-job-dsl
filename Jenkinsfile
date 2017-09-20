node {
    stage('Create seed job') {
      jobDsl scriptText: '''job(\'seed-job\'){
        println("${GIT_URL}")
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
      }'''
    }
}