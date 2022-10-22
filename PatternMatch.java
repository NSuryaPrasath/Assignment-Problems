package newclass;

import java.util.*;


public class PatternMatch
{
	public static void search(char[] text,char[] pattern)
	{
		int txtlen=text.length,end=pattern.length,start=0;
		ArrayList<Integer> ind=new ArrayList<Integer>();
		Arrays.sort(pattern);
		char[] sorted= new char[end];
		while(end++<=txtlen)
		{
			int index=0;
			for(int i=start;i<end-1;i++)
			{
				sorted[index++]=text[i]; 
			}
			Arrays.sort(sorted);
			if(Arrays.equals(pattern, sorted))
			{
				ind.add(start);
			}
			start++;
		}
		for(int i:ind)
		{
			System.out.println("  Found at Index "+i);
		}
	}
	public static void main(String args[])
	{
		char[] txt1= {'B','A','C','D','G','A','B','C','D','A'},pat1= {'A','B','C','D'};
		char[] txt2= {'A','A','A','B','A','B','A','A'},pat2= {'A','A','B','A'};
		System.out.println("i. ");
		search(txt1,pat1);
		System.out.println("\nii. ");
		search(txt2,pat2);
		
	}
}