import java.util.*;
import java.io.*;


public class POTUS
{
	static final int INITIAL_CAP = 5;
	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("FATAL ERROR: Must enter one input filename on command line\n");
			System.exit(0);
		}
		Scanner infile = new Scanner( new File( args[0] ) );

		// INSERT IN ORDER:  LOAD  FILE INTO ARR BUT SORT IT AS YOU LOAD IT, NOT AFTER.
		// USE RECURSIVE BINARY SEARCH TO FIND THE INSERTION INDEX FOR THE NEXT INCOMING NUMBER

		int[] arr = new int[INITIAL_CAP];
		int arrCnt= 0;
		while (infile.hasNextInt())
		{
			if ( arrCnt==arr.length-1 )
				arr = doubleMyLength(arr);
			insertInOrder( arr, arrCnt, infile.nextInt() );
			++arrCnt;
		}
		infile.close();

		arr = trimMyLength( arr, arrCnt );
		System.out.println("Sorted array of " + arr.length + " ints from " + args[0] + " after insert in order:" );
		printArray( arr );  // we trimmed it so count == length so we don't bother to pass in count

	} // END MAIN

	// - - - - - - - - - - - - - METHODS - - - - - - - - - - - - -

	static void insertInOrder( int[] arr, int cnt, int newVal ){
	
		int insertIndex = bSearch(arr,0,cnt-1,newVal);
		
		for (int i=cnt; i>=insertIndex; i--){			
			arr[i+1]=arr[i];
		}
		
		arr[insertIndex] = newVal;
	}

	// We do not need to pass in count. The incoming lo and hi define the range
	public static int bSearch(int[] arr, int lo, int hi, int key){
	
		int mid = lo+(hi-lo)/2;//calc mid	
	
		if(lo>hi){//base case
			if(arr[mid]!=0){
				if(arr[mid]<key){
					mid++;			
				}
			}
		
			return mid;	
		}
	
		if(key == arr[mid]){//test to see if you found it
			return mid;
		}
	
		if(key <= arr[mid]){
			hi = mid-1;
		}
	
		if(key >= arr[mid]){
			lo = mid+1;
		}
		//adjust hi or lo < or >
	
		return bSearch(arr,lo,hi,key);
		
		}
		
	



    static void printArray( int[] arr  ){
	
        for( int i=0 ; i<arr.length ;++i )
            System.out.print(arr[i] + " " );
        System.out.println();
    }

	// USE AS IS - DO NOT MODIFY
	static int[] doubleMyLength( int[] oldArr )
	{
		int[] newArr = new int[ oldArr.length * 2 ];
		for ( int i=0; i<oldArr.length ; ++i )
			newArr[i] = oldArr[i];
		return newArr;
	}

	// USE AS IS - DO NOT MODIFY
	static int[] trimMyLength( int[] oldArr, int cnt )
	{
		int[] newArr = new int[ cnt ];
		for ( int i=0; i<cnt ; ++i )
			newArr[i] = oldArr[i];
		return newArr;
	}

} // END PROJECT2
