package recursion;
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
		sc.close();
	}
	
	public static void coinToss(int n)
	{
		coinToss(n, "", false);
	}

	private static void coinToss(int n, String osf, boolean flag) {
	
		if(n == 0)
		{
			System.out.println(osf);
			return;
		}
		
		if(!flag)
		{
			coinToss(n-1, osf + "H", true);
			coinToss(n-1, osf + "T", false);
		}
		else
			coinToss(n-1, osf + "T", false);

	}
}
