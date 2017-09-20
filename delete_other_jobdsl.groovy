job('delete_other_jobs') {
    scm {
        git {
            remote {
                url('https://github.com/markmclaren/test-job-dsl')
            }
        }
    }
    steps {
        dsl {
            external('**/*_jobdsl.groovy')
            removeAction('DELETE')
        }
    }
}