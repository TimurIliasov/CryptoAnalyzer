package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
