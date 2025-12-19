package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.constants.Cipher;
import ru.javarush.iliasov.cryptoanalyzer.constants.Constants;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) throws IOException {
        long start = System.nanoTime();
        String inputPath = parameters[0];
        String outputPath = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        String text = Files.readString(Path.of(inputPath));
        String alphabet = detectAlphabet(text);
        String encode = Cipher.encrypt(text,key, alphabet);

        Files.writeString(Path.of(outputPath),encode);
        long end = System.nanoTime();
        System.out.println("how much time took to encode: " +(end - start)/1_000_000+"msec");

        return new Result("encode all right", ResultCode.OK);
    }

    private static String detectAlphabet(String text){
        int rus = 0, eng = 0;
        for (char c: text.toCharArray()){
            if (Constants.rus.indexOf(c)>=0){
                rus++;
            } else if (Constants.eng.indexOf(c)>=0) {
                eng++;

            }
        }
        return rus>=eng?Constants.rus:Constants.eng;
    }
}

