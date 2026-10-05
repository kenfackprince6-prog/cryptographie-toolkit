public class CaesarCipher{
    private final int key;
    public CaesarCipher( int key){
        this.key= key%26;
    }
    public String encrypt(String text){
        String ergebnis="";
        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
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
    public String decrypt(String original){
        CaesarCipher invers= new CaesarCipher (26 - this.key);
        return invers.encrypt(original);

    }
    public static void main(String[] args){
        CaesarCipher cipher= new CaesarCipher(3);
        String chiffre= cipher.encrypt("Hallo Welt");
        System.out.println(chiffre);
        String normal= cipher.decrypt(chiffre);
        System.out.println(normal);

    }
}