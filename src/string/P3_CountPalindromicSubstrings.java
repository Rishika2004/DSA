package string;

import java.util.Scanner;

public class P3_CountPalindromicSubstrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int count = countPalindromicSubstrings(s);
		System.out.println(count);
		sc.close();
	}
	
	public static int countPalindromicSubstrings(String s)
	{
		int count = 0;
		for(int i=0; i<s.length(); i++)
		{
			for(int j=i; j<s.length(); j++)
			{
				String ss = s.substring(i, j+1);
				
				if(isPalindrome(ss))
				{
					//System.out.println(ss);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static boolean isPalindrome(String s)
	{
		boolean isPalindrome = true;
		int i=0, j=s.length()-1;
		while(i < j)
		{
			if(s.charAt(i) != s.charAt(j))
			{
				isPalindrome = false;
				break;
			}
			i++;
			j--;
		}
		return isPalindrome;
	}
}
