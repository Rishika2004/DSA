package recursion;
import java.util.ArrayList;
//Print the results of coin toss with NO consecutive heads
//Sample input :
//3
//Sample output :
//HTH
//HTT
//THT
//TTH
//TTT
import java.util.Scanner;

public class CoinTossNoConsecutiveHeads {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		coinToss(n);
//		ArrayList<String> list = coinTossR(n);
//		for(String s : list)
//			System.out.println(s);
		sc.close();
	}
	
	public static void coinToss(int n)
	{
		coinToss(n, "", false);
	}

	//flag -> true : last call was of head

	private static void coinToss(int n, String osf, boolean flag) {
	
		if(n == 0)
		{
			System.out.println(osf);
			return;
		}
		
		if(!flag)  //last call was not head
		{
			coinToss(n-1, osf + "H", true);
			coinToss(n-1, osf + "T", false);
		}
		else
			coinToss(n-1, osf + "T", false);
	}
	
	public static ArrayList<String> coinTossR(int n)
	{
		if(n == 0)
		{
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		
		ArrayList<String> smallAns = coinTossR(n-1);
		
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0; i<smallAns.size(); i++)
		{
			if(smallAns.get(i).length() == 0 || smallAns.get(i).charAt(0) != 'H')
			{
				ans.add("H" + smallAns.get(i));
			}
		}
		
		for(int i=0; i<smallAns.size(); i++)
		{
			ans.add("T" + smallAns.get(i));
		}
		
		return ans;
	}
}
