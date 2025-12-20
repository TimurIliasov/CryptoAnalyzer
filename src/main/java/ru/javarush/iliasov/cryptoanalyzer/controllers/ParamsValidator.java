package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

public class ParamsValidator {
    public static void requireCount(String[] parameters, int expected){
        if (parameters==null||parameters.length != expected){
            throw new AppExceptions("Expected " + expected + " parameters, got "+
                    (parameters==null?0:parameters.length));
        }
    }
}
