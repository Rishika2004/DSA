package recursion;

public class String_subsequences {

	public static String[] Subsequences(String input)
	{
		if(input.length() == 0)
		{
			String[] ans = {""};
			return ans;
		}
		
		String smallAns[] = Subsequences(input.substring(1));
		
		String[] ans = new String[2 * smallAns.length];
		
		for(int i=0;i<smallAns.length;i++)
		{
			ans[i] = smallAns[i];
		}
		int j=0;
		for(int i=smallAns.length;i<ans.length;i++)
		{
			ans[i] = input.charAt(0) + smallAns[j++]; 
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		String s = "abcd";
		String ans[] = Subsequences(s);
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}
}
