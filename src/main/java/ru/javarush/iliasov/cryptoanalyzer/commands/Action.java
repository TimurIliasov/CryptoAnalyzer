package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.entity.Result;

import java.io.IOException;

public interface Action {
    Result execute(String[] parameters) throws IOException;
}
