job('helloworld') {
    steps {
        println("Hello From Inside the Seed Job!")
        shell('echo "Hello World!"')
    }
}

job('helloworld-another') {
    steps {
        shell('echo "Another Hello World!"')
    }
}