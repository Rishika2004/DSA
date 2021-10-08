package stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {

	public static boolean duplicateBracket(String s)
	{
		boolean checkDupl = false;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '-' || s.charAt(i) == '%')
			{
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')')
			{
				if(stack.peek() == '(')
				{
					checkDupl = true;
				}
				else
				{
					while(stack.peek() != '(')
					{
						stack.pop();
					}
					stack.pop();
				}
			}
		}
		return checkDupl;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(duplicateBracket(s));
		sc.close();
	}
	
}
