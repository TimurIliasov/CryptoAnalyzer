package ru.javarush.iliasov.cryptoanalyzer.exceptions;

public class AppExceptions extends RuntimeException{
    public AppExceptions() {
    }

    public AppExceptions(String message) {
        super(message);
    }

    public AppExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AppExceptions(Throwable cause) {
        super(cause);
    }
}
