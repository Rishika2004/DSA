package recursion;

import java.util.Scanner;

public class PermutationsOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		permutations(s);
		sc.close();
	}

	public static void permutations(String s) {
		
		permutations(s, "");
	}
	
	private static void permutations(String s, String osf)
	{
		if(s.length() == 0)
		{
			System.out.println(osf);
			return;
		}
		
		for(int i=0; i<s.length(); i++)
		{
			permutations(s.substring(0, i) + s.substring(i+1), osf + s.charAt(i));
		}
	}
	
}
