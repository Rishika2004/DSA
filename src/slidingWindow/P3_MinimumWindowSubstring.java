package slidingWindow;

import java.util.Scanner;
import java.util.HashMap;

public class P3_MinimumWindowSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		String ans = minWindowSubstring(s1, s2);
		System.out.println(ans);

		sc.close();
	}
	
	public static String minWindowSubstring(String s1, String s2)
	{
		String ans = "";
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i=0; i<s2.length(); i++)
		{
			char ch = s2.charAt(i);
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		
		int i=-1, j=-1;
		int mct = 0;  //match count
		int dmct = s2.length(); //desired match count
		HashMap<Character, Integer> map1 = new HashMap<>();
		
		while(i < s1.length() -1)
		{
			//acquire
			while(i < s1.length()-1 && mct < dmct)
			{
				i++;
				char ch = s1.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				if(map1.get(ch) <= map2.getOrDefault(ch, 0))
					mct++;
			}
			
			//release and collect answer
			while(j < i && mct == dmct)
			{
				//pans -> potential answer
				String pans = s1.substring(j+1, i+1);
				if(ans.length() == 0 || pans.length() < ans.length())
					ans = pans;
			
				j++;
				char ch = s1.charAt(j);
				if(map1.get(ch) == 1)
					map1.remove(ch);
				else
					map1.put(ch, map1.get(ch)-1);
				
				if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0))
					mct--;
			}
		}
		
		return ans;
	}
}