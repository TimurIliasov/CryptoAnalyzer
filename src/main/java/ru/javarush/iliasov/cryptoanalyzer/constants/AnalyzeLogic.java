package ru.javarush.iliasov.cryptoanalyzer.constants;

import java.util.Arrays;

public class AnalyzeLogic {
    public record AnalyzeResult(int key, String alphabet){

    }

    public static AnalyzeResult analyze(String text){
        text = text.toUpperCase();
        int[] rusFreq = new int[Constants.rus.length()];
        int[] engFreq = new int[Constants.eng.length()];

        for (char c:text.toCharArray()){
            int rus = Constants.rus.indexOf(c);
            if (rus>=0){
                rusFreq[rus]++;
                continue;
            }
            int eng = Constants.eng.indexOf(c);
            if (eng>=0){
                engFreq[eng]++;
            }
        }
        int rusCount = Arrays.stream(rusFreq).sum();
        int engCount = Arrays.stream(engFreq).sum();
        if (rusCount+engCount<5){
            throw  new IllegalArgumentException("Text is to short for statistical analysis");
        }
        boolean isRussian = rusCount>engCount;

        String alphabet = isRussian?Constants.rus:Constants.eng;
        char expected = isRussian?'О':'E';//Наиболее частые буквы это 'О' и 'E'
        int[] freq = isRussian?rusFreq:engFreq;

        int maxIndex = getIndexOfMax(freq);


        int expectedIndex = alphabet.indexOf(expected);
        int key = maxIndex - expectedIndex;

        if (key<0){
            key+=alphabet.length();
        }
        return new AnalyzeResult(key, alphabet);

    }

    private static int getIndexOfMax(int[] freq) {
        int max = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i]>freq[max]){
                max = i;
            }
        }
        return max;
    }
}

