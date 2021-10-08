package stack;
import java.util.*;
public class BalancedBrackets {

	public static boolean balancedBrackets(String s)
	{
		boolean isBal = true;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[')
			{
				stack.push(ch);
			}
			else if(ch == ')')
			{
				isBal = handleClosing(stack, '(');
				if(!isBal)
					return false;
			}
			else if(ch == '}')
			{
				isBal = handleClosing(stack, '{');
				if(!isBal)
					return false;
			}
			else if(ch == ']')
			{
				isBal = handleClosing(stack, '[');
				if(!isBal)
					return false;
			}
		}
		
		if(!stack.isEmpty())
			isBal = false;
		
		return isBal;
	}
	
	public static boolean handleClosing(Stack<Character> stack, char corresOpen)
	{
		if(stack.isEmpty())
			return false;
		else if(stack.peek() != corresOpen)
			return false;
		
		stack.pop();
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(balancedBrackets(s));
		sc.close();
	}
}
