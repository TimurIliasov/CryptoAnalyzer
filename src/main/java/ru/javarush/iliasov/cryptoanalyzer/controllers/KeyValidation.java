package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

public class KeyValidation {
    public static void validates(int key, String alphabet){
        if (key<0||key>=alphabet.length()){
            throw new AppExceptions("Key must be in range [0..."+(alphabet.length()-1)+"]");
        }
    }
}
