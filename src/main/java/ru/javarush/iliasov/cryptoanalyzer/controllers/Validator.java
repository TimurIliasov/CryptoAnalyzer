package ru.javarush.iliasov.cryptoanalyzer.controllers;

public interface Validator<T> {
    void validate(T value);
}
