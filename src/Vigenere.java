import java.util.ArrayList;

public class Vigenere extends Substitution {

    private ArrayList<Caesar> caesars;
    private String key;

    /**
     * Creates a default key.
     */
    public Vigenere(){
        this.key = "";
    }

    /**
     * Creates a key based on the input param and creates a list of caesar objects.
     * @param newKey is the key to be used for encryption and decryption
     */
    public Vigenere(String newKey){
        this.key = newKey;

        caesars = new ArrayList<>(newKey.length());

        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            int shift = currentChar - 'A';

            Caesar newCaesar = new Caesar(shift);

            caesars.add(newCaesar);

            //System.out.println("Vigenere Current Char: " + currentChar + " | " + "Vigenere Shift: " + shift + " | "  + "Caesar Objecr: "+ newCaesar);
        }
    }

    /**
     * Handles encryption and decryption.
     * @param args are all the inputs from a user
     */
    public static void main(String[] args) {
        if(args.length < 3){
            System.out.print("Too few parameters!\n");
            System.out.print("Usage: java Vigenere encrypt key \"cipher text\"\n");

            return;
        }
        if(args.length > 3){
            System.out.print("Too many parameters!\n");
            System.out.print("Usage: java Vigenere encrypt key \"cipher text\"\n");

            return;
        }

        String action = args[0];
        String key = args[1];
        String input = args[2];

        Vigenere vigenere = new Vigenere(key);

        if(action.equals("encrypt")){
            String encryptedString = vigenere.encrypt(input);
            System.out.print(encryptedString);
        }
        else if(action.equals("decrypt")){
            String decryptedString = vigenere.decrypt(input);
            System.out.print(decryptedString);
        }
        else{
            System.out.print("The first parameter must be \"encrypt\" or \"decrypt\"!\n");
            System.out.print("Usage: java Vigenere encrypt key \"cipher text\"\n");
        }
    }

    /**
     * Encrypts a single character.
     * @param c the character to encrypt
     * @return returns the encrypted character
     */
    @Override
    public char encrypt(char c) {

        char encryptedChar = c;

        Caesar caesar = caesars.remove(0);
        encryptedChar = caesar.encrypt(c);
        caesars.add(caesar);

        return encryptedChar;
    }

    /**
     * Decrypts a single character.
     * @param c the character to decrypt
     * @return returns the decrypted character
     */
    @Override
    public char decrypt(char c) {

        char decryptedChar = c;

        Caesar caesar = caesars.remove(0);
        decryptedChar = caesar.decrypt(c);
        caesars.add(caesar);

        return decryptedChar;
    }
}
