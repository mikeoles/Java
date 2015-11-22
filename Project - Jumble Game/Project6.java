import java.io.*;
import java.util.*;

public class Project6
{
	public static void main(String args[]) throws Exception{
		BufferedReader infileDict = new BufferedReader(new FileReader(args[0]));
		BufferedReader infileJumble = new BufferedReader(new FileReader(args[1]));
		
		ArrayList<String> dict = new ArrayList<String>();
		ArrayList<String> jumble = new ArrayList<String>();

		while(infileDict.ready()){
			dict.add(infileDict.readLine());
		}
		while(infileJumble.ready()){
			jumble.add(infileJumble.readLine());		
		}		
		
		Collections.sort(dict);
		Collections.sort(jumble);
		HashMap<String,String> list = new HashMap<String,String>();		
		
		for(int i = 0;i<dict.size();i++){
			String word = dict.get(i);
			char[] arr = word.toCharArray();  
			Arrays.sort( arr );            
			String sortedWord = new String( arr );
			if(list.containsKey(sortedWord)){
				list.put(sortedWord, list.get(sortedWord) + " " + word );
			}else{
				list.put(sortedWord,word);
			}
		}
		
		for(int i = 0;i<jumble.size();i++){
			String jumbleWord = jumble.get(i);
			System.out.print(jumbleWord + " ");
			char[] arr = jumbleWord.toCharArray();  
			Arrays.sort( arr );            
			String sortedJumble = new String( arr );
			if(list.containsKey(sortedJumble)){
				System.out.println(list.get(sortedJumble));
			}else{
				System.out.println();
			}
		}
	}
}