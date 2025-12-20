package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.constants.Constants;
import ru.javarush.iliasov.cryptoanalyzer.constants.DeCipher;
import ru.javarush.iliasov.cryptoanalyzer.controllers.KeyValidation;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) throws IOException {
        if (parameters.length != 3){
            return new Result("Usage: encode <inputFile> <key> <outputFile>",
                    ResultCode.ERROR);
        }
        String inputPath = parameters[0];
        String outputPath = parameters[1];
        String keyStr = parameters[2];

        try {
            String text = Files.readString(Path.of(inputPath));
            String alphabet = getAlphabet(text);
            int key = KeyValidation.validates(keyStr, alphabet);
            String decode = DeCipher.decrypt(text,key, alphabet);

            Files.writeString(Path.of(outputPath),decode);
            return new Result("decode all right", ResultCode.OK);
        } catch (IllegalArgumentException e) {
            return new Result(e.getMessage(), ResultCode.ERROR);
        } catch (IOException e) {
            return new Result(e.getMessage(), ResultCode.ERROR);
        }
    }

    private static String getAlphabet(String text) {
        text = text.toUpperCase();
        int rus = 0, eng = 0;
        for (char c: text.toCharArray()){
            if (Constants.rus.indexOf(c)>=0){
                rus++;
            } else if (Constants.eng.indexOf(c)>=0) {
                eng++;
            }
        }
        if (rus + eng == 0){
            throw new IllegalArgumentException("No alphabet characters found");
        }
        return rus>=eng?Constants.rus:Constants.eng;
    }
}
