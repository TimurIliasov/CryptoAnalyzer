package ru.javarush.iliasov.cryptoanalyzer;

import ru.javarush.iliasov.cryptoanalyzer.constants.BFLogic;
import ru.javarush.iliasov.cryptoanalyzer.constants.Cipher;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;

import java.io.IOException;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

        String original = "HELLO ПРИВЕТ WORLD МИР";
        String enc = Cipher.encrypt(original, 5);
        String dec = BFLogic.decryptBrute(enc);

        System.out.println(enc);
        System.out.println(dec);

    }
}


