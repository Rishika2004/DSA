package string;

import java.util.*;
public class P7_FormBiggestNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			
			String s = formLargestNumber(a);
			System.out.println(s);
		}
		sc.close();
	}
	
	public static String formLargestNumber(int a[])
	{
		int n = a.length;
		String[] strArr = new String[n];
		for(int i=0; i<n; i++)
		{
			String s = Integer.toString(a[i]);
			strArr[i] = s;
		}
		
		Arrays.sort(strArr, new Comparator<String>(){
			
			public int compare(String a, String b) {
				
				String ab = a + b;
				String ba = b + a;
				
				return ba.compareTo(ab);
				
				//ab.compareTo(ba) -> increasing order
				//ba.compareTo(ab) -> decreasing order
				
			}
		});
	
		if(strArr[0].equals("0"))
			return "0";
		
		String ans = "";
		for(String s : strArr)
			ans += s;
		
		return ans;
	}
}
