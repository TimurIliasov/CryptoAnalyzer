package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.constants.BFLogic;
import ru.javarush.iliasov.cryptoanalyzer.controllers.FileValidation;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce implements Action{
    @Override
    public Result execute(String[] parameters) throws IOException {
        try {
            String inputPath = parameters[0];
            String outputPath = parameters[1];

            FileValidation.validateReadable(inputPath);
            FileValidation.validatorWritable(outputPath);

            String text = Files.readString(Path.of(inputPath));

            String decryptedBrute = BFLogic.decryptBrute(text);
            Files.writeString(Path.of(outputPath),decryptedBrute);
            return new Result("BruteForce completed", ResultCode.OK);
        } catch (IOException e) {
            return new Result(e.getMessage(), ResultCode.ERROR);
        }
    }
}
