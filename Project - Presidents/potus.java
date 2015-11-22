import java.util.*;
import java.io.*;

// NO CMD ARGS - ALL FILENAMES MUST BE HARDOCDED AS I HAVE DONE FOR YOU HERE

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader("state2Presidents.txt") );
		BufferedReader infile2 = new BufferedReader( new FileReader("allPresidents.txt") );
		BufferedReader infile3 = new BufferedReader( new FileReader("allStates.txt") );

		// YOUR CODE HERE TO DECLARE MAPS OR SETS TO HOLD THE DATA OF THESE THREE INPUT FILES
		
		
		// ################# STEP #1 worth 40% ###################

		// YOUR CODE HERE TO READ infile1 INTO A Map

		System.out.println( "The following states had these presidents born in them:\n");  // DO NOT REMOVE OR MODIFY

		TreeMap<String,ArrayList<String>> stateToPres = new TreeMap<String,ArrayList<String>>();
		String line;
		String state;		
		while ( infile1.ready() ){
			line = infile1.readLine();
			ArrayList<String> presNamesList = new ArrayList<String>();				
			String [] presNamesArray = (line.split(" "));
			state = presNamesArray[0];		
			for(int i=1;i<presNamesArray.length;i++){
				presNamesList.add(presNamesArray[i]);
			}	
			Collections.sort(presNamesList);
			stateToPres.put(state,presNamesList);
		}
		for(String s : stateToPres.keySet()){
			System.out.print(s + " ");
			for (String t : stateToPres.get(s)){
				System.out.print(t + " ");
			}
			System.out.println();
		}
		System.out.println();

		// ################# STEP #2 worth 20% ###################

		System.out.println( "\nList of presidents and the state each was born in:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO PRINT THE INVERSION OF THE MAP worth 15%
		TreeMap<String,String> presToState = new TreeMap<String,String>();
		for(String s : stateToPres.keySet()){
			for (String t : stateToPres.get(s)){
				presToState .put(t,s);
			}
		}
		for(String s : presToState.keySet()){
			System.out.println(s + " " + presToState .get(s));
		}		
		System.out.println();



		// ################# STEP #3 worth 20% ###################

		System.out.println( "\nThese presidents were born before the states were formed:\n");  // DO NOT REMOVE OR MODIFY
		
		ArrayList<String> allPresidents = new ArrayList<String>();
		while (infile2.ready()){
			allPresidents.add(infile2.readLine());
		}
		
		for(String s : presToState.keySet()){
			allPresidents.remove(s);
		}	

		for(int i=0;i<allPresidents.size();i++){
			System.out.println(allPresidents.get(i));
		}





		// ################# STEP #4 worth 20% ###################

		System.out.println( "\nThese states had no presidents were born in them:\n");

		ArrayList<String> allStates = new ArrayList<String>();
		while (infile3.ready()){
			allStates.add(infile3.readLine());
		}
		
		for(String s : stateToPres.keySet()){
			allStates.remove(s);
		}	
		
		for(int i=0;i<allStates.size();i++){
			System.out.println(allStates.get(i));
		}




	} // END MAIN

	//              - - - - - - - - - - -  H E L P E R    M E T H O D S     D O W N    H E R E  - - - - - - - - - -







}	// END POTUS CLASS