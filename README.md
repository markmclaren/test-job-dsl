# Experiments with Job DSL

In case you happen upon this.  I offer no support!  This is purely an area for my experimentation with Jenkins, [Job DSL plugin](https://wiki.jenkins.io/display/JENKINS/Job+DSL+Plugin) and the concept of *configuration as code*.  Based on ideas found at Jenkins [User Power Moves](https://github.com/jenkinsci/job-dsl-plugin/wiki/User-Power-Moves) and some help from StackOveflow;[How to handle exceptions in a Jenkins Job DSL seed job?](https://stackoverflow.com/questions/46330697/how-to-handle-exceptions-in-a-jenkins-job-dsl-seed-job/)

These experiments require the following Jenkins plugins (in addition to those installed with a default installation):

[Job DSL Plugin](https://wiki.jenkins.io/display/JENKINS/Job+DSL+Plugin)

[Repository Connector Plugin](https://wiki.jenkins.io/display/JENKINS/Repository+Connector+Plugin)

[Text-finder Plugin](https://wiki.jenkins.io/display/JENKINS/Text-finder+Plugin)

## Seed job creation:

The *Jenkinsfile* (Jenkins Pipeline) creates the Job DSL seed job.  This is *"imported"* into Jenkins by means of creating a new pipeline job and configuring the SCM section to look at this Git repository.   Running this pipeline will create/update the seed job.

From an empty Jenkins installation it is easier to import a Jenkinsfile from a Git repo than to manually create a Seed job in the UI.

This seed job establishes:

* the Git repo where the Job DSL files live
* repository-connector configuration to acquire additional libraries (e.g. [Jasypt](http://www.jasypt.org/))
* the additional classpath (to include the Jasypt library)
* the path for the job dsl files

## Running the seed job

Before you run the seed job (in order to replicate Jasypt usage), you need to add a "secret text" credential (using the credentials plugin) called "SECRET_DECRYPTION_KEY".

Once created by the pipeline, the seed job itself will create a Jenkins job (or possibly multiple jobs) for each \*_jobdsl.groovy file it finds in the Git repo

## About Jasypt and the use of SECRET_DECRYPTION_KEY

Each of the jobs we plan to run require Jasypt encyption keys.  

We will **not** store the raw encryption key in our Git repo - this is very insecure (and defeats the point of Jayspt).

Instead we will further encrypt each encyrption key with a SECRET_DECRYPTION_KEY for the purpose of Jenkins job creation (double encryption if you like), this new key will not be stored in any Git repo but it will allow the storage of the job encryption keys in a Git repo securely.
