# Experiments with Job DSL

In case you happen upon this.  I offer no support!  This is purely an area for my experimentation with Jenkins, Job DSL and the concept of *configuration as code*.  Based on ideas found at Jenkins [User Power Moves](https://github.com/jenkinsci/job-dsl-plugin/wiki/User-Power-Moves)

## Seed job creation:

The *Jenkinsfile* (Jenkins Pipeline) creates the Job DSL seed job.  

From an empty Jenkins installation it is easier to import a Jenkinsfile from a Git repo than to manually create a Seed job in the UI.

This seed job establishes:

* the Git repo where the Job DSL files live
* a gradle build to acquire required additional libraries (e.g. Jasypt)
* the additional classpath (to include the Jasypt library)
* the path for the job dsl files

## Running the seed job

Once created by the pipeline, the seed job itself will create a Jenkins job (or possibly multiple jobs) for each \*_jobdsl.groovy file it finds in the Git repo
