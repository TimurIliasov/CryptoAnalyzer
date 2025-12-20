package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

public class KeyValidation {
    public static int validates(String keyStr, String alphabet){
        try {
            int key = Integer.parseInt(keyStr);
            if (key<0||key>=alphabet.length()){
                throw new AppExceptions("Key must be in range [0..."+(alphabet.length()-1)+"]");
            }
            return key%alphabet.length();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Key must be a number");
        }
    }
}
