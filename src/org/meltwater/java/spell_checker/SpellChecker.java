package org.meltwater.java.spell_checker;

/**
 * 
 * @author Izzoe
 *@credit: Peter Norvig's work
 *@url: http://norvig.com/spell-correct.html.  
 */
import java.io.*;
import java.util.*;

public class SpellChecker {
    
    /**
     * Stores all the words of the dictionary. The suggestWord is to indicate whether the word is spelled correctly or not
     */
	Hashtable<String,String> dictionary;   
    boolean suggestWord ;   
    FileWriter filewriter;
    
    public static void main(String [] args) 
    {
        @SuppressWarnings("unused")
		SpellChecker checker = new SpellChecker();
    }
    
    @SuppressWarnings("resource")
	public SpellChecker() 
    {
        try {
			filewriter = new FileWriter(new File("document-corrected.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	dictionary = new Hashtable<String,String>();
        System.out.println("******This is a spellchecker that reads an inputed file, outputs the file and corrections*****");
        System.out.println("The spell checker would check every line from the input file and then give suggestions if needed after each line. \n\n");
        
        try 
        {
            /**
             * Read and store the words of the dictionary
             */
        	String dic = "dictionary.txt";
        	BufferedReader dictReader = new BufferedReader(new FileReader(dic));
           
            while (dictReader.ready()) 
            {
                String dictInput = dictReader.readLine() ;
                String [] dict = dictInput.split("\\s");
                
                // key and value are identical
                for(int i = 0; i < dict.length; i++) 
                {
                    dictionary.put(dict[i], dict[i]);
                }
            }
            dictReader.close();
            
            // Read and check the input from the text file 
            String file = "inputDocument.txt";
          
            BufferedReader inputFile = new BufferedReader(new FileReader(file));
            System.out.println("Reading from "+file);
            
            String line;
        	while((line = inputFile.readLine()) != null){
        		filewriter.append(line + "\n");
        	}
        	filewriter.append("\n\n\n");
        	
        	inputFile = new BufferedReader(new FileReader(file));
            
            // Initializing a spelling suggest object
            SpellingSuggest suggest = new SpellingSuggest("dictionary.txt");
         
            /**
             * Reads inputed file lines one by one and checks to see if the words are spelt correctly
             */
            while ( inputFile.ready() ) 
            {
                String s = inputFile.readLine() ;
                System.out.println (s);
                String[] result = s.split("\\s");
                
                 for (int x = 0; x < result.length; x++)
                {
                    suggestWord = true;
                    String outputWord = checkWord(result[x]);
                    
                    if(suggestWord)
                    {
                        System.out.println("Suggestions for "+result[x]+" are:  "+suggest.correct(outputWord)+"\n");
                        filewriter.append("Suggestions for "+result[x]+" are:  "+suggest.correct(outputWord)+"\n");
                        filewriter.flush();
                    }
                }
            }
            inputFile.close();
        }
        catch (IOException e) 
        {
            System.out.println("IOException Occured! ");
            e.printStackTrace();
           // System.exit(-1);
        }
    }
    
    /**
     * Checks whether the words are found in the dictionary. If yes, then they are correctly spelt and should be returned as they are. If not,
     * a suggestWord method should be implemented.
     * @param wordToCheck checks if the word is in the dictionary, if yes, return as it is, otherwise wordSuggest
     * @return
     */
    public String checkWord(String wordToCheck) 
    {
        String wordCheck, unpunctWord;
        String word = wordToCheck.toLowerCase();
        
        if ((wordCheck = (String)dictionary.get(word)) != null)
        {
            suggestWord = false;       
            return wordCheck;
        }
        
        int length = word.length();
        
        /**
         * Removing punctuation at the end of the word and returning the word
         * It checks if the word exists in the dictionary, if not, it should implement suggestWord
         */
        if (length > 1 && word.substring(0,1).equals("\"")) 
        {
            unpunctWord = word.substring(1, length);
            
            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;            
                return wordCheck ;
            }
            else 
                return unpunctWord;      
        }
 
        /**
         *  Checking if "." or ",",etc.. at the end is the problem
         *  such as 'home.' when home is present in the dictionary
         *  It checks whether the word without the punctuation is in the dictionary, 
         *  if not, implement wordSuugest
         */
        if( word.substring(length - 1).equals(".") || word.substring(length - 1).equals(",") ||  
        	word.substring(length - 1).equals("!") || word.substring(length - 1).equals(";") || 
        	word.substring(length - 1).equals(":"))
        {
            unpunctWord = word.substring(0, length-1);
            
            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;           
                return wordCheck ;
            }
            else
            {
                return unpunctWord;                  
            }
        }

        /**
         * // Checking for "!\""
         * After all these checks too, word could not be corrected, 
         * hence it must be misspelt word. return and ask for suggestions
         */
        if (length > 2 && word.substring(length-2).equals(",\"")  || word.substring(length-2).equals(".\"") 
            || word.substring(length-2).equals("?\"") || word.substring(length-2).equals("!\"") )
        {
            unpunctWord = word.substring(0, length-2);
            
            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;           
                return wordCheck ;
            }
            else // not found
                return unpunctWord;                  
        }
        
        return word;
    }
    
}
