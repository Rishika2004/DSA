package recursion;

public class String_subsequences_print {

	public static void string_subsequences(String s)
	{
		string_subsequences(s,"");
	}
	private static void string_subsequences(String s, String outputSoFar) {

		if(s.length()==0)
		{
			System.out.println(outputSoFar);
			return;
		}
		
		string_subsequences(s.substring(1),outputSoFar);
		
		string_subsequences(s.substring(1),outputSoFar + s.charAt(0));
	}
	
	public static void main(String[] args)
	{
		String s = "abc";
		string_subsequences(s);
	}
}

