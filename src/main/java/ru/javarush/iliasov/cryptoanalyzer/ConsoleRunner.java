package ru.javarush.iliasov.cryptoanalyzer;



import ru.javarush.iliasov.cryptoanalyzer.entity.Result;

import java.io.IOException;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

    }
}


