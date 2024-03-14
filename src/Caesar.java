public class Caesar extends MonoAlphaSubstitution{
    private int shift;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static char[] alphabetArray;

    /**
     * Sets a default shift value.
     */
    public Caesar(){
        this.shift = 0;
    }

    /**
     * Sets the shift value to the input param.
     * @param shift is the value to be used as the shift key for encryption
     */
    public Caesar(int shift) {
        this.shift = shift;

        if (shift < 0)
            shift += 26;

        createMapping();
    }

    /**
     * Handles encryption and decryption.
     * @param args are all the inputs from a user
     */
    public static void main(String[] args){

        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
            return;
        }
        if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
            return;
        }

        String action = args[0];
        int shift = Integer.parseInt(args[1]);
        String input = args[2];

        Caesar caesar = new Caesar(shift);
        MonoAlphaSubstitution monoAlphaSubstitution = new MonoAlphaSubstitution(caesar.mapping);

        if (action.equals("encrypt")) {
            String encryptedString = monoAlphaSubstitution.encrypt(input);
            System.out.print(encryptedString);
        } else if (action.equals("decrypt")) {
            String decryptedString = monoAlphaSubstitution.decrypt(input);
            System.out.print(decryptedString);
        } else {
            System.out.print("The first parameter must be \"encrypt\" or \"decrypt\"!\n");
            System.out.print("Usage: java Caesar encrypt n \"cipher text\"\n");
        }
    }

    /**
     * Duplicates and converts a string to upper case
     * @param string is the string to duplicate and convert to upper case
     * @return returns the new upper case string
     */
    private String toUpperCase(String string){
        String returnValue = "";
        for (char character: string.toCharArray()) {
            returnValue += Character.toUpperCase(character);
        }

        return returnValue;
    }

    /**
     * Creates an encryption map based on the given shift.
     */
    private void createMapping(){
        alphabetArray = alphabet.toCharArray();

        for (char currentChar: alphabetArray){
            int currentIndex = alphabet.indexOf(currentChar);

            mapping += currentChar;
            mapping += alphabet.charAt(properMod((currentIndex + shift),26));
        }

        mapping += toUpperCase(mapping);
    }

    /**
     * Accurate Mod
     * @param a is the input value
     * @param b is the mod value
     * @return returns the result of a MOD b
     */
    public static int properMod(int a, int b) {
        return (a % b + b) % b;
    }
}