public class CaesarCipher{
    private final int key;
    public CaesarCipher( int key){
        this.key= key%26;
    }
    public String encrypt(String plaintext){
        String ergebnis="";

        for(int i=0; i<plaintext.length(); i++){
            char c = plaintext.charAt(i);

            if(c>='A'&& c<='Z'){
                ergebnis= ergebnis + (char) ((c-'A'+this.key)%26+'A');

            } else if (c>='a'&& c<='z'){
                ergebnis= ergebnis + (char) ((c-'a'+this.key)%26+'a');
            } else {
                ergebnis= ergebnis + c ;
            }
        }
        return ergebnis;
    }
    public String decrypt(String ciphertext){
        CaesarCipher invers= new CaesarCipher (26 - this.key);
        return invers.encrypt(ciphertext);
    }
    public void bruteForceAttack(String ciphertext){
        System.out.println("--- Brute-Force-Angriff ---");

        for(int testkey=0; testkey<26 ; testkey++){
        CaesarCipher testCipher= new CaesarCipher(testkey);
        String kandidat= testCipher.decrypt(ciphertext);
        System.out.println("Schluessel " + testkey + ":" + kandidat);
    }
    }
    public static void main(String[] args){
        CaesarCipher cipher= new CaesarCipher(3);

        String chiffre= cipher.encrypt("Hallo Welt");
        System.out.println(chiffre);

        String normal= cipher.decrypt(chiffre);
        System.out.println("Entschluesselt: " + normal);

        System.out.println();
        cipher.bruteForceAttack(chiffre);


    }
}