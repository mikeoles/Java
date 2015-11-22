import java.io.*;
import java.util.*;

public class Pacs
{
	public static void main( String args[] )throws Exception
	{
		BufferedReader pacsFile = new BufferedReader( new FileReader( "pacs.txt" ) );
		BufferedReader membersFile = new BufferedReader( new FileReader( "members.txt" ) );

		ArrayList<String> allPacs = new ArrayList<String>();
		while (pacsFile.ready()){
			allPacs.add(pacsFile.readLine());
		}
			
		TreeMap<String,ArrayList<String>> pacsMembers = new TreeMap<String,ArrayList<String>>();
		String pac;
		while (membersFile.ready()){
			ArrayList<String> pacsMembersList = new ArrayList<String>();		
			String[] pacsMembersArray = membersFile.readLine().split(" ");
			pac = pacsMembersArray[0];
			for(int i=1;i<pacsMembersArray.length;i++){
				pacsMembersList.add(pacsMembersArray[i]);
			}
			pacsMembers.put(pac,pacsMembersList);
		}
	
		
		TreeMap<String,TreeSet<String>> pacsMembership = new TreeMap<String,TreeSet<String>>();
		for(int i=0;i<allPacs.size();i++){
			TreeSet<String> membersList = new TreeSet<String>();		
			pac = allPacs.get(i);
			for(String s : pacsMembers.keySet()){			
				if(pacsMembers.get(s).contains(pac)){					
					membersList.add(s);
				}
			}
			pacsMembership.put(pac,membersList);		
		}		
		
		for(String s : pacsMembership.keySet()){
			System.out.print(s + " ");
			for (String t : pacsMembership.get(s)){
				System.out.print(t + " ");
			}
			System.out.println();
		}		
	}
}