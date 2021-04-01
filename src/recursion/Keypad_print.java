package recursion;

public class Keypad_print {
	
	//static int count = 0;
	
	public static void keypad(int n)
	{
		keypad(n,"");
	}
	
	private static void keypad(int n,String output)
	{
		if(n==0)
		{
			System.out.println(output);
			//count++;
			return;
		}
		
		String s = getcode(n%10);
		
		for(int i=0;i<s.length();i++)
		{
			keypad(n/10,s.charAt(i)+output);
		}
	}
	
	private static String getcode(int n)
	{
		String choice[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		return choice[n];
	}
	
	public static void main(String[] args)
	{
		keypad(278);
		//System.out.println(count);
	}
}
