package string;

import java.util.Scanner;

public class P2_CheckPalindrome {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		boolean isPalindome = checkPalindrome(s);
		if(isPalindome)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	
		sc.close();
	}
	
	public static boolean checkPalindrome(String s)
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
