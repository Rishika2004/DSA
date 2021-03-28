package recursion;

public class CoinToss {

	public static void main(String[] args)
	{
		//coinTossPrint(3);
		String[] ans = coinToss(3);
		for(String s : ans)
			System.out.println(s);
	}
	
	public static void coinTossPrint(int n)
	{
		coinTossPrint(n, "");
	}
	
	private static void coinTossPrint(int n, String osf)
	{
		if(n == 0)
		{
			System.out.println(osf);
			return;
		}
		
		coinTossPrint(n-1, osf + 'H');
		coinTossPrint(n-1, osf + 'T');
	}
	
	public static String[] coinToss(int n)
	{
		if(n == 0)
		{
			String ans[] = {""};
			return ans;
		}
		
		String smallAns[] = coinToss(n-1);
		
		String ans[] = new String[2 * smallAns.length];
		
		int k = 0;
		
		for(int i=0; i<smallAns.length; i++)
			ans[k++] = 'H' + smallAns[i];
		
		for(int i=0; i<smallAns.length; i++)
			ans[k++] = 'T' + smallAns[i];
		
		return ans;
	}
}
