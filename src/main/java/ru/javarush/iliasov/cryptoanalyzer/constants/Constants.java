package ru.javarush.iliasov.cryptoanalyzer.constants;

import java.io.File;

/**
 *
 */
public class Constants {
    private static final  String rus = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
    private static final  String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String cypher = "1234567890";
    private static final String signsSpace = "!@#$%^&*(){}[],.<>/?";
    public static final String ALPHABET = rus+eng+rus.toLowerCase()+eng.toLowerCase()+ cypher + signsSpace;
    public static final String TXT_FOLDER = System.getProperty("user.dir")+ File.separator+"text"+File.separator;
}
