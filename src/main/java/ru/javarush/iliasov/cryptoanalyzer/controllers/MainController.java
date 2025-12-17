package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.commands.Action;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;

import java.io.IOException;

public class MainController {
    public Result doAction(String actionName, String[] parameters) throws IOException {
        Action action = ActionFactory.find(actionName);
        Result execute = action.execute(parameters);
        return execute;
    }
}
