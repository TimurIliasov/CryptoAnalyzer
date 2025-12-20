package ru.javarush.iliasov.cryptoanalyzer.controllers;

import ru.javarush.iliasov.cryptoanalyzer.exceptions.AppExceptions;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidation {
    public static void validateReadable(String path){
        if(path==null||path.isBlank()){
            throw new AppExceptions("File path is empty");
        }
        Path p = Path.of(path);

        if (!Files.exists(p)){
            throw new AppExceptions("File does not exists: "+ path);
        }

        if (!Files.isReadable(p)){
            throw new AppExceptions("Can not read file: " + path);
        }
    }

    public static void validatorWritable(String path){
        if (path==null||path.isBlank()){
            throw new AppExceptions("File path is empty");
        }

        Path p = Path.of(path);

        if (Files.exists(p)&&!Files.isWritable(p)){
            throw new AppExceptions("File does not exists: " + path);
        }
    }
}
