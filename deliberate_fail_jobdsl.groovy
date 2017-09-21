job('deliberate-fail') {
    try {
        throw new Exception("Arrrgggghhh")
    } catch (Exception ex){
        println("deliberate-fail job is [UNSTABLE]")
    }
}