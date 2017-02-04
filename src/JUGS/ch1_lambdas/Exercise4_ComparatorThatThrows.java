package JUGS.ch1_lambdas;
import java.util.Comparator;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
@FunctionalInterface
public interface Exercise4_ComparatorThatThrows<T> extends Comparator<T>
{
    @Override
    default int compare(final T t1, final T t2)
    {
        try
        {
            return compareThrows(t1, t2);
        }
        catch (final Exception e)
        {      
            throw new RuntimeException(e);
        }
    }

    public int compareThrows(final T t1, final T t2) throws Exception;
}