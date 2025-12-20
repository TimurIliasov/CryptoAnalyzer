package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.constants.AnalyzeLogic;
import ru.javarush.iliasov.cryptoanalyzer.constants.Cipher;
import ru.javarush.iliasov.cryptoanalyzer.controllers.FileValidation;
import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Analyzer implements Action {

    @Override
    public Result execute(String[] parameters) throws IOException {
        if (parameters.length != 3){
            return new Result("Usage: analyze<encryptedFile> <dictionaryFile> <outputFile>",
                    ResultCode.ERROR);
        }

        String encryptedFile = parameters[0];
        String dictionaryFile = parameters[1];
        String analyzedFile = parameters[2];

        String encryptedText = Files.readString(Path.of(encryptedFile));
        try {
            FileValidation.validateReadable(encryptedFile);
            FileValidation.validateReadable(dictionaryFile);
            FileValidation.validatorWritable(analyzedFile);

            encryptedText = Files.readString(Path.of(encryptedFile));
            AnalyzeLogic.AnalyzeResult analyzeResult = AnalyzeLogic.analyze(encryptedText);
            int decryptKey = analyzeResult.alphabet().length() - analyzeResult.key();

            String decrypted = Cipher.encrypt(encryptedText, decryptKey, analyzeResult.alphabet());
            Files.writeString(Path.of(analyzedFile), decrypted);

            return new Result("File analyzed. Key: " + analyzeResult.key(), ResultCode.OK);
        } catch (IllegalArgumentException e) {
            return new Result(e.getMessage(), ResultCode.ERROR);
        }
    }
}


