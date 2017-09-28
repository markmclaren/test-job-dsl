node {
    stage('Create seed job') {
jobDsl scriptText: '''job(\'seed-job\') {
    println("${BUILD_NUMBER}")
    scm {
        git {
            remote {
                url(\'https://github.com/markmclaren/test-job-dsl\')
            }
        }
    }
    steps {
        resolveArtifacts {
            targetDirectory(\'lib\')
            artifact {
                groupId(\'org.jasypt\')
                artifactId(\'jasypt\')
                version(\'1.9.2\')
            }
            artifact {
                groupId(\'org.bouncycastle\')
                artifactId(\'bcprov-jdk16\')
                version(\'1.46\')
            }
        }	    
        dsl {
            external \'**/*_jobdsl.groovy\'
            additionalClasspath \'lib/*.jar\'
        }
    }
    wrappers {
        credentialsBinding {
            string(\'SECRET_DECRYPTION_KEY\', \'SECRET_DECRYPTION_KEY\')
        }
    }
    publishers {
        textFinder(/[UNSTABLE]/, \'\', true, false, true)
    }    
}'''
    }
}
