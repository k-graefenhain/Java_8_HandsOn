package JUGS.ch1_lambdas;

import java.io.IOException;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise4_RunnableThatThrowsExample  
{
    public static void main(String[] args)
    {
        // Unhandled exception type IOException
        //final Runnable runner1 = () -> { System.out.println("RunnableThatThrows"); throw new IOException(); };
        //runner1.run();

        final Exercise4_RunnableThatThrows runner2 = () -> { System.out.println("RunnableThatThrows"); throw new IOException(); };
        runner2.run();
    }
}