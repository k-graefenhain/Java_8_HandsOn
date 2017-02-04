package JUGS.ch1_lambdas;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
@FunctionalInterface
public interface Exercise4_RunnableThatThrows extends Runnable
{
    @Override
    default void run()
    {
        try
        {
            runThrows();
        }
        catch (final Exception e)
        {      
            throw new RuntimeException(e);
        }
    }

    public void runThrows() throws Exception;
}