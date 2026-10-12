public class VigenereCipher {
    private final String key;

    public VigenereCipher(String key){
        this.key=key;
    }
    private int buchstabeZuZahl(char c){
            if (c >= 'A' && c <= 'Z') return c - 'A';
            if (c >= 'a' && c <= 'z') return c - 'a';
            return 0;

    }
    private char verschiebe(char c, int shift) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ((c - 'A' + shift + 26) % 26 + 'A');
        } else if (c >= 'a' && c <= 'z') {
            return (char) ((c - 'a' + shift + 26) % 26 + 'a');
        }
        return c;
    }
    public String encrypt(String plaintext){
        String ergebnis="";
        int keyIndex=0;
    for(int i=0; i<plaintext.length(); i++){
        char p=plaintext.charAt(i);
     if((p>='A' && p<='Z') || (p>='a' && p<='z')){
         char k= this.key.charAt(keyIndex % this.key.length());
         int schluessel= buchstabeZuZahl(k);
         ergebnis=ergebnis+verschiebe(p, schluessel);
         keyIndex++;
     }else{
         ergebnis= ergebnis+p;
     }
    }
    return ergebnis;
    }
    public String decrypt(String ciphertext){
        String ergebnis="";
        int keyIndex=0;
        for(int i=0; i<ciphertext.length(); i++){
            char p=ciphertext.charAt(i);
            if((p>='A' && p<='Z')||(p>='a' && p<='z')){
                char k= this.key.charAt(keyIndex%this.key.length());
                int schluessel=buchstabeZuZahl(k);
                ergebnis=ergebnis+verschiebe(p, -schluessel);
                keyIndex++;
            }else{
                ergebnis= ergebnis+p;
            }
        }
        return ergebnis;

    }

    public static void main(String[] args){
        VigenereCipher cipher= new VigenereCipher("KEY");
        String chiffre= cipher.encrypt("Hallo Welt");
        System.out.println(chiffre);
        System.out.println(cipher.decrypt(chiffre));

    }
}
