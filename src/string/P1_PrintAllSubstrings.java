package string;

import java.util.Scanner;

//You have given a string, you need to print of all the substring of given string.
//substring -> contiguous
//Sample Input
//abcd
//Sample Output
//a ab abc abcd b bc bcd c cd d 
public class P1_PrintAllSubstrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); //next() is used to take a single word as input
		
		printSubstring(s);
		sc.close();
	}
	
	public static void printSubstring(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			for(int j=i; j<s.length(); j++)
			{
				System.out.println(s.substring(i, j+1));
			}
		}
	}
}
