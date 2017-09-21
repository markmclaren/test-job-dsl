import org.jasypt.util.text.BasicTextEncryptor

// Fetch decryption key via the credentials plugin
def secret = "do_not_use_this!"

if ("${SECRET_DECRYPTION_KEY}" != null) {
    secret = "${SECRET_DECRYPTION_KEY}"
}

// Never do this!
println("Secret: ")
println("${SECRET_DECRYPTION_KEY}")
println(secret)
println(secret.length())

textEncryptor = new BasicTextEncryptor();
textEncryptor.setPassword(secret);

def stringToEncrypt = "Hello World!"
def encryptedString = encrypt(stringToEncrypt)
def decryptedString = decrypt(encryptedString)

job('helloworld-with-encryption') {

    steps {
        println("Hello From Inside the Seed Job!")
        shell('echo "' + encryptedString + '"')
        shell('echo "' + decryptedString + '"')
    }
}

String encrypt(String text) {
    return textEncryptor.encrypt(text);
}

String decrypt(String text) {
    return textEncryptor.decrypt(text);
}