package ru.javarush.iliasov.cryptoanalyzer.constants;

public class Cipher {
    public static String encrypt(String text, int key, String alphabet){
        StringBuilder result = new StringBuilder();
        text=text.toUpperCase();

        for (char ch: text.toCharArray()){
            if (alphabet.indexOf(ch)>=0){
                int index = alphabet.indexOf(ch);
                result.append(alphabet.charAt((index+key)%alphabet.length()));
            }else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
