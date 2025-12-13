package ru.javarush.iliasov.cryptoanalyzer;

import ru.javarush.iliasov.cryptoanalyzer.controllers.MainController;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application() {
        mainController = new MainController();

    }

    public Result run(String[] args) {
        if (args.length==0){
            throw new AppExceptions("no args");
        }

            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        Result result = mainController.doAction(action, parameters);
        return result;
    }
}
