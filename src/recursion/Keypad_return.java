package recursion;

public class Keypad_return {

	public static String[] keypad(int input)
	{
		if(input == 0 || input == 1)
		{
			String[] ans = {""};
			return ans;
		}
		
		String smallAns[] = keypad(input/10);
		
		String s = getcode(input%10);
		
		String ans[] = new String[smallAns.length*s.length()];
		
		int k=0;
		
		for(int i=0;i<smallAns.length;i++)
		{
			for(int j=0;j<s.length();j++)
			{
				ans[k++] = smallAns[i] + s.charAt(j);
			}
		}
		return ans;
	}
	
	private static String getcode(int n)
	{
		String s[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		return s[n];
	}
	
//	private static String get(int n)
//	{
//		String ans = "";
//		switch(n)
//		{
//			case 2:
//				ans = "abc";
//				break;
//			case 3:
//				ans = "def";
//				break;
//			case 4:
//				ans = "ghi";
//				break;
//			case 5:
//				ans = "jkl";
//				break;
//			case 6:
//				ans = "mno";
//				break;
//			case 7:
//				ans = "pqrs";
//				break;
//			case 8:
//				ans = "tuv";
//				break;
//			case 9:
//				ans = "wxyz";
//				break;
//		}
//		return ans;
//	}
//	
	public static void main(String[] args)
	{
		String ans[] = keypad(79);
		for(int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
	}
}
