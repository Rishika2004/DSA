package recursion;

import java.util.Scanner;

public class GenerateAllValidParenthesis {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = generateParenthesis(n);
		System.out.println("All possible valid Parenthesis : " + count);
		sc.close();
	}

	public static int generateParenthesis(int n) {
		
		return generateParenthesis(n, "", 0, 0);
	}

	//cob = count opening brackets
	//ccb = count closing brackets
	private static int generateParenthesis(int n, String osf, int cob, int ccb)
	{
		if(cob == n && ccb == n)
		{
			System.out.println(osf);
			return 1;
		}
		
		if(ccb > cob)
			return 0;
		
		if(cob > n)
			return 0; 
		
		int count = 0;
		count += generateParenthesis(n, osf + "(", cob+1, ccb);
		count += generateParenthesis(n, osf + ")", cob, ccb+1);
		return count;
	}
	
	
}