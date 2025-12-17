package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.commands.Action;
import ru.javarush.iliasov.cryptoanalyzer.commands.BruteForce;
import ru.javarush.iliasov.cryptoanalyzer.commands.Decoder;
import ru.javarush.iliasov.cryptoanalyzer.commands.Encoder;
import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

public enum ActionFactory {
    ENCODE(new Encoder()), DECODE(new Decoder()), BRUTEFORCE(new BruteForce());

    private final Action action;

    ActionFactory(Action action) {
        this.action = action;
    }

    public static Action find(String actionName){
        try {

            ActionFactory value = ActionFactory.valueOf(actionName.toUpperCase());
            return value.action;
        }catch (IllegalArgumentException e){
            throw new AppExceptions("not found "+actionName,e);
        }
    }
}
