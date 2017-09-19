import org.jasypt.util.text.BasicTextEncryptor

BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
textEncryptor.setPassword("123");

def stringToEncrypt = "Hello World!"

def commandToRun = 'echo "' + stringToEncrypt + '"'

job('helloworld') {
    steps {
        println("Hello From Inside the Seed Job!")
        shell(commandToRun)
    }
}