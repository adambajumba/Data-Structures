package org.meltwater.java.spell_checker;

/**
 *@author Izzoe
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;


class SpellingSuggest {

	private final HashMap<String, Integer> DataBaseWords = new HashMap<String, Integer>();

	/**
	 * Reading the dictionary and updating the probabilistic values of the words accordingly
	 * @param file the file containing words to be checked against the dictionary for possible corrections
	 * @throws IOException in case no suggestions can come up
	 */
	public SpellingSuggest(String file) throws IOException 
	{
	    try
	    {
    		BufferedReader in = new BufferedReader(new FileReader(file));
	    	Pattern p = Pattern.compile("\\w+");
	    	for(String temp = ""; temp != null; temp = in.readLine() )      
	    	{                                                              
	    		Matcher m = p.matcher(temp.toLowerCase());
	    		while(m.find())
	    		{
	    		    //This will serve as an indicator to probability of a word.
	    			DataBaseWords.put( (temp = m.group()), DataBaseWords.containsKey(temp) ? DataBaseWords.get(temp) + 1 : 1 );  
	    	    }                                                                                                  
	    	}
	    	in.close();
	    }
	    catch(IOException e)
	    {
	        System.out.println("An error occured!");
	        e.printStackTrace();
	    }
	}

	/**
	 * adds all possible corrections to the word passed and returns an array
	 * @param word the word to be checked for the possible suggestions
	 * @return return an array containing all possible corrections to the word passed
	 */
	private final ArrayList<String> edits(String word) 
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i=0; i < word.length(); ++i) 
		{
		    result.add(word.substring(0, i) + word.substring(i+1)); 
		}
		for(int i=0; i < word.length()-1; ++i) 
		{
		    result.add(word.substring(0, i) + word.substring(i+1, i+2) + word.substring(i, i+1) + word.substring(i+2)); 
		}
		for(int i=0; i < word.length(); ++i) 
		{    
		    for(char c='a'; c <= 'z'; ++c) 
		    {
		        result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i+1));
		    }
		}
		for(int i=0; i <= word.length(); ++i) 
		{
		    for(char c='a'; c <= 'z'; ++c) 
		    {
		        result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
		    }
		}
		return result;
	}

	/**
	 * Checks if the database/dictionary of words contains the word.
	 * If no, it should iterate through the list of all possible corrections to the word
	 * @param word the word to be checked against the dictionary
	 * @return returns word
	 */
	public final String correct(String word) 
	{
		if(DataBaseWords.containsKey(word)) 
		{
		    return word;   
		}
		ArrayList<String> list_edits = edits(word);
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		
		for(String s : list_edits) 
		{
		    if(DataBaseWords.containsKey(s)) 
		    {
		        candidates.put(DataBaseWords.get(s),s);
		    }
		}
		
		// In the first stage of error correction, any of the possible corrections
		//from the list_edits are found in the dictionary 
		// then we return the one verified correction with maximum probability.
		if(candidates.size() > 0) 
		{
		     return candidates.get(Collections.max(candidates.keySet()));
		}
		// In the second stage we apply the first stage method on the possible collections of the list_edits.
		for(String s : list_edits) 
		{    
		     for(String w : edits(s))
		     { 
		            if(DataBaseWords.containsKey(w))
		            { 
		                candidates.put(DataBaseWords.get(w),w);
		            }
		     }
		}
		   
		    return candidates.size() > 0 ? candidates.get(Collections.max(candidates.keySet())) : "Sorry but no possible corrections found!";
	}

	public static void main(String [] args) throws IOException 
	{
		if(args.length > 0) 
		{
		    System.out.println((new SpellingSuggest("dictionary.txt")).correct(args[0]));
	    }
	}
}
