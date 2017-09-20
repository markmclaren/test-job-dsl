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
            external('**/*.dsl')
            removeAction('DELETE')
        }
    }
}