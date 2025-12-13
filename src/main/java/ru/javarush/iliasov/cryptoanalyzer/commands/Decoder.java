package ru.javarush.iliasov.cryptoanalyzer.commands;

import ru.javarush.iliasov.cryptoanalyzer.entity.Result;
import ru.javarush.iliasov.cryptoanalyzer.entity.ResultCode;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        return new Result("decode all right", ResultCode.OK);
    }
}
