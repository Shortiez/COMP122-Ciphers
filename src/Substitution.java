public abstract class Substitution implements Cipher {
    /**
     * Encrypts a single character.
     * @param c is the character that should be encrypted.
     * @return returns the encrypted version of c.
     */
    public abstract char encrypt(char c);
    /**
     * Decrypts a single character.
     * @param c is the character that should be decrypted.
     * @return returns the decrypted version of c.
     */
    public abstract char decrypt(char c);

    /**
     * Encrypts a single String.
     * @param plaintext is the String that should be encrypted.
     * @return returns the encrypted version of plaintext.
     */
    public String encrypt(String plaintext){
        String encryptedString = "";

        for (int i = 0; i < plaintext.length(); i++) {
            encryptedString += encrypt(plaintext.charAt(i));
        }

        return encryptedString;
    }

    /**
     * Decrypts a single String.
     * @param cryptotext is the String that should be decrypted.
     * @return returns the decrypted version of cryptotext.
     */
    public String decrypt(String cryptotext){
        String decryptedString = "";

        for (int i = 0; i < cryptotext.length(); i++) {
            decryptedString += decrypt(cryptotext.charAt(i));
        }

        return decryptedString;
    }
}
