package ru.javarush.iliasov.cryptoanalyzer.constants;

public class DeCipher {
    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();

        for (char ch:text.toCharArray()){
            if (Constants.rus.indexOf(ch)>=0){
                int index = Constants.rus.indexOf(ch);
                int newIndex = index-key;
                if (newIndex<0){
                    newIndex+=Constants.rus.length();
                }
                result.append(Constants.rus.charAt(newIndex));
            } else if (Constants.eng.indexOf(ch)>=0) {
                int index = Constants.eng.indexOf(ch);
                int newIndex = index-key;
                if (newIndex<0){
                    newIndex+=Constants.eng.length();
                }
                result.append(Constants.eng.charAt(newIndex));
            }else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
