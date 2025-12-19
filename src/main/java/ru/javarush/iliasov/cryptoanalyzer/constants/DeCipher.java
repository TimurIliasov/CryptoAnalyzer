package ru.javarush.iliasov.cryptoanalyzer.constants;

public class DeCipher {
    public static String decrypt(String text, int key, String alphabet) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();

        for (char ch:text.toCharArray()){
            int index = alphabet.indexOf(ch);
            if (index>= 0){
                int newIndex = index-key;
                if (newIndex<0){
                    newIndex+=alphabet.length();
                }
                result.append(alphabet.charAt(newIndex));
            }else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
