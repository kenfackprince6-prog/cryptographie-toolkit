public class ErstesProgramm {
    public static String verschluesseln(String text, int schluessel){
        String ergebnis="";
        for (int i=0; i<text.length(); i++){
            char c =text.charAt(i);
            if ( c>='A'&& c<= 'Z') {
                ergebnis= ergebnis + (char) ((c-'A'+schluessel)%26+'A');
            } else if ( c >= 'a' && c<= 'z'){
                ergebnis= ergebnis + (char) ((c-'a'+schluessel)%26+'a');
            }else{
                ergebnis= ergebnis+ c;
            }
        }
        return ergebnis;

    }
    public static void main(String[] args){
        String klartext = "Hallo Welt";
        String chiffre = verschluesseln( klartext, 3);
        String zurueck = verschluesseln( chiffre, 23);
        System.out.println(chiffre);
        System.out.println(zurueck);

    }
}

