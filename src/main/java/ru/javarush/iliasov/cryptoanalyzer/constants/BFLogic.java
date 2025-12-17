package ru.javarush.iliasov.cryptoanalyzer.constants;

public class BFLogic {
    public static String decryptBrute(String text){
        text=text.toUpperCase();
        int bestScore = 0;
        String bestResult = null;

        for (int key = 0; key <Math.max(Constants.rus.length(), Constants.eng.length()) ; key++) {
            String decryptedBrute = DeCipher.decrypt(text,key);
            int score = scoreText(decryptedBrute);

            if (score>bestScore){
                bestScore = score;
                bestResult = decryptedBrute;
            }
        }
        return bestResult!=null? bestResult:"Не удалось расшифровать текст";
    }

    private static int scoreText(String text){
        int score = 0;

        if (text.contains(" ПРИВЕТ ")) score += 5;
        if (text.contains(" МИР ")) score += 5;
        if (text.contains(" ЭТО ")) score += 3;
        if (text.contains(" НА ")) score += 2;

        if (text.contains(" HELLO ")) score += 5;
        if (text.contains(" WORLD ")) score += 5;
        if (text.contains(" THE ")) score += 3;
        if (text.contains(" AND ")) score += 2;

        return score;
    }
}
