node {
    jobDsl scriptText: '''job(\'seed-job\'){
      scm {
          git {
              remote {
                  url(\'https://github.com/markmclaren/test-job-dsl\')
              }
         }
      }
      steps {
          gradle(\'libs\') 
          dsl {
             external \'**/*.dsl\'
             additionalClasspath \'lib/*.jar\'
          }
      }    
    }'''
}