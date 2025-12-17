package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.constants.DeCipher;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) throws IOException {
        String inputPath = parameters[0];
        String outputPath = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        String text = Files.readString(Path.of(inputPath));
        String decode = DeCipher.decrypt(text,key);

        Files.writeString(Path.of(outputPath),decode);
        return new Result("decode all right", ResultCode.OK);
    }
}
