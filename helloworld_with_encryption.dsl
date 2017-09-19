import org.jasypt.util.text.BasicTextEncryptor

BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
textEncryptor.setPassword("123");

def stringToEncrypt = "Hello World!"
def commandToRun = 'echo "' + encrypt(stringToEncrypt) + '"'

job('helloworld-with-encryption') {

    steps {
        println("Hello From Inside the Seed Job!")
        shell(commandToRun)
    }
}

static String encrypt(String in){
    return textEncryptor.encrypt(in);
}

static String decrypt(String in){
    return textEncryptor.decrypt(in);
}