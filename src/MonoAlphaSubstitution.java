public class MonoAlphaSubstitution extends Substitution{

    protected String mapping;
    private static char[] mappingArray;

    /**
     * Creates a default mapping.
     */
    public MonoAlphaSubstitution(){
        this.mapping = "";
    }

    /**
     * Creates a new mapping based on the input.
     * @param newMapping is the mapping to be used for encryption and decryption
     */
    public MonoAlphaSubstitution(String newMapping){
        this.mapping = newMapping;
        this.mappingArray = mapping.toCharArray();
    }

    /**
     * Handles encryption and decryption.
     * @param args are all the inputs from a user
     */
    public static void main(String[] args){
        if(args.length < 3){
            System.out.print("Too few parameters!\n");
            System.out.print("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");

            return;
        }
        if(args.length > 3){
            System.out.print("Too many parameters!\n");
            System.out.print("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");

            return;
        }

        String action = args[0];
        String mapping = args[1];
        String input = args[2];

        MonoAlphaSubstitution monoAlphaSubstitution;

        if(!mapping.isEmpty() && !mapping.isBlank()){
            monoAlphaSubstitution = new MonoAlphaSubstitution(mapping);
        }
        else {
            monoAlphaSubstitution = new MonoAlphaSubstitution();
        }

        if(action.equals("encrypt")){
            String encryptedString = monoAlphaSubstitution.encrypt(input);
            System.out.print(encryptedString);
        }
        else if(action.equals("decrypt")){
            String decryptedString = monoAlphaSubstitution.decrypt(input);
            System.out.print(decryptedString);
        }
        else{
            System.out.print("The first parameter must be \"encrypt\" or \"decrypt\"!\n");
            System.out.print("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"\n");
        }
    }

    /**
     * Encrypts a single character.
     * @param c the character to encrypt
     * @return returns the encrypted character
     */
    @Override
    public char encrypt(char c) {
        char encryptedCharacter = ' ';

        if(mapping.isBlank()){
            return c;
        }

        mappingArray = mapping.toCharArray();

        for (int i = 0; i < mappingArray.length; i += 2) {
            if (mappingArray[i] == c) {
                encryptedCharacter = mappingArray[i + 1];
                break;
            } else {
                encryptedCharacter = c;
            }
        }

        return encryptedCharacter;
    }

    /**
     * Decrypts a single character.
     * @param c the character to decrypt
     * @return returns the decrypted character
     */
    @Override
    public char decrypt(char c) {
        char encryptedCharacter = ' ';

        if(mapping.isBlank()){
            return c;
        }

        mappingArray = mapping.toCharArray();

        for (int i = 1; i < mappingArray.length; i += 2) {
            if (mappingArray[i] == c) {
                encryptedCharacter = mappingArray[i - 1];
                break;
            } else {
                encryptedCharacter = c;
            }
        }

        return encryptedCharacter;
    }
}
