package JUGS.ch1_lambdas;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise2_FunctionalInterfacesExample
{
    public static void main(final String[] args)
    {
        final StringToIntConverter stringToInt = str -> str.length();

        final StringToStringConverter stringToStringTrimmer = str -> str.trim();
        final StringToStringConverter stringToUpperCaseString = str -> str.toUpperCase();
        
        System.out.println("stringToInt('Java') => " + stringToInt.convert("Java"));
        System.out.println("stringToString('  Michael  ') => '" + stringToStringTrimmer.convert("  Michael  ") + "'");
        System.out.println("stringToUpperCase('Hands On') => " + stringToUpperCaseString.convert("Hands On"));
    }

    // Bildet Objekte von Typ String auf int ab.
    @FunctionalInterface
    public interface StringToIntConverter
    {
        int convert(final String input);
    }

    // StringToStringMapper: Bildet Objekte von Typ String auf String.
    @FunctionalInterface
    public interface StringToStringConverter
    {
        String convert(final String input);
    }
}