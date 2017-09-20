job('helloworld') {
    steps {
        println("Hello From Inside the Seed Job!")
        shell('echo "Hello World!"')
    }
}