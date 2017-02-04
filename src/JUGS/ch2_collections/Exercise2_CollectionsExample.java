package JUGS.ch2_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise2_CollectionsExample
{
	public static void main(String[] args)
    {
        final List<String> names = removeIf_External_Iteration();
        System.out.println("JDK 7 removeIf: " + names);
        
        final List<String> allNnames = createNamesList();
        allNnames.removeIf(currentName -> currentName.length() < 4);
        System.out.println("JDK 8 removeIf: " + names);
    }
	
    private static List<String> removeIf_External_Iteration()                                  
    {                                                                                         
        final List<String> names = createNamesList();                                        
        final Iterator<String> it = names.iterator();                                        
        while (it.hasNext())                                                                  
        {                                                                                       
            final String currentName = it.next();                                                   
            if (currentName.length() < 4)                                                           
               it.remove();                                                                           
        }                                                                                   
        return names;                                                                          
    }                                                                                   
    private static List<String> createNamesList()                                       
    {                                                                                   
        final List<String> names = new ArrayList<>();                                         
        names.add("Michael");                                                                 
        names.add("Tim");                                                                   
        names.add("Flo");                                                                   
        names.add("Clemens");                                                               
        return names;                                                                        
    }
}