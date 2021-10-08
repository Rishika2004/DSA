package recursion;

import java.util.Scanner;

public class AllCodesPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		allCodes(s, "");
	}
	
	private static void allCodes(String s, String osf)
	{
		if(s.length() == 0)
		{
			System.out.println(osf);
			return;
		}
		
		int first = s.charAt(0) - '0';
		char ch = getChar(first);
		allCodes(s.substring(1), osf + ch);
		
		if(s.length() > 1)
		{
			int second = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
			if(second >=10 && second <=26)
			{
				ch = getChar(second);
				allCodes(s.substring(2), osf + ch);
			}
		}
	}
	
	private static char getChar(int n)
	{
		return (char)(96 + n);
	}
}
