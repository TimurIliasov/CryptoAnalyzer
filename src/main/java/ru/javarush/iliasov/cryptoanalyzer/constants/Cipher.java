package ru.javarush.iliasov.cryptoanalyzer.constants;

public class Cipher {
    public static String encrypt(String text, int key){
        StringBuilder result = new StringBuilder();
        text=text.toUpperCase();

        for (char ch: text.toCharArray()){
            if (Constants.rus.indexOf(ch)>=0){
                int index = Constants.rus.indexOf(ch);
                result.append(Constants.rus.charAt((index+key)%Constants.rus.length()));
            } else if (Constants.eng.indexOf(ch)>=0) {
                int index = Constants.eng.indexOf(ch);
                result.append(Constants.eng.charAt((index+key)%Constants.eng.length()));
            }else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
