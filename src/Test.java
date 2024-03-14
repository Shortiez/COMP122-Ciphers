public class Test {

    public static void main(String[] args){
        Caesar caesar = new Caesar(10);
        String caesarOutput = caesar.decrypt("pex") ; // caesarOutput should be "fun"

        System.out.println(caesarOutput);

        MonoAlphaSubstitution monoAlphaSubstitution = new MonoAlphaSubstitution("akbjcidhegffgehdicjbka");
        char monoAlphaSubstitutionOutput = monoAlphaSubstitution.encrypt('i');  // outc should be 'c'

        System.out.println(monoAlphaSubstitutionOutput);

        Vigenere vigenere = new Vigenere("COMPONETWOTWO");
        String vigenereOutput = vigenere.encrypt("fun fun fun"); // outv should be "hiz thr big"

        System.out.println(vigenereOutput);
    }
}
