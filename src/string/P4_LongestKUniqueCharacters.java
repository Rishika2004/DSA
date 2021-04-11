package string;

import java.util.Scanner;

//Longest K Unique Characters Substring
//s="abbbaacda" k=2  -> answer = 6
public class P4_LongestKUniqueCharacters {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
			String s = sc.next();
			int k = sc.nextInt();
			int max_len = KUniques(s, k);
			System.out.println(max_len);
		}
		
		sc.close();
	}
	
	public static int KUniques(String s, int k)
	{
		int freq[] = new int[256];
		int start = 0;
		int count = 0;
		int max_len = Integer.MIN_VALUE;
		
		for(int i=0; i<s.length(); i++)
		{
			if(freq[s.charAt(i)] == 0)
				count++;
			
			freq[s.charAt(i)]++;
			
			while(count > k)
			{
				freq[start]--;
				if(freq[start] == 0)
					count--;
				start++;
			}
			
			max_len = Math.max(max_len, i-start+1);
		}
		
		if(max_len < k)
			return -1;
		else
			return max_len;
	}
}