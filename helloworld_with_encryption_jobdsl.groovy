import org.jasypt.util.text.BasicTextEncryptor

textEncryptor = new BasicTextEncryptor();
textEncryptor.setPassword("123");

def stringToEncrypt = "Hello World!"
def commandToRun = 'echo "' + encrypt(stringToEncrypt) + '"'

job('helloworld-with-encryption') {

    steps {
        println("Hello From Inside the Seed Job!")
        shell(commandToRun)
    }
}

String encrypt(String text) {
    return textEncryptor.encrypt(text);
}

String decrypt(String text) {
    return textEncryptor.decrypt(text);
}