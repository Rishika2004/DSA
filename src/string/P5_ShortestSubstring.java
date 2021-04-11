package string;

import java.util.Scanner;
import java.util.HashMap;

public class P5_ShortestSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ss = sc.nextLine();
		
		String ans = shortestSubstring(str, ss);
		System.out.println(ans);
		
		sc.close();
	}
	
	public static String shortestSubstring(String str, String ss)
	{
		String ans = "";
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i=0; i<ss.length(); i++)
		{
			char ch = ss.charAt(i);
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		
		int mct = 0;
		int dmct = ss.length();
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true)
		{
			boolean f1 = false;
			boolean f2 = false;
			
			//acquire 
			while(i < str.length() - 1 && mct < dmct)
			{
				i++;
				char ch = str.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				
				if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0))
				{
					mct++;
				}
				f1 =true;
			}
				
			//release and collect answer
			while(j <i && mct == dmct)
			{
				String temp = str.substring(j+1, i+1);
				if(ans.length() == 0 || temp.length() < ans.length())
					ans = temp;
				
				j++;
				char ch = str.charAt(j);
				if(map1.get(ch) == 1)
					map1.remove(ch);
				else
					map1.put(ch, map1.get(ch)-1);
				
				if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0))
					mct--;
				
				f2 = true;
			}
			
			if(f1 == false && f2 == false)
				break;
		}
		
		return ans;
    
	}
}