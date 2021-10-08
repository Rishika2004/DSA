package stack;
import java.util.*;
public class NextGreaterRight {

	public static int[] ngr(int arr[])
	{
		int ans[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=arr.length-1; i>=0; i--)
		{
			if(stack.isEmpty())
				ans[i] = -1;
			else if(stack.peek() > arr[i])
				ans[i] = stack.peek();
			else
			{
				while(!stack.isEmpty() && stack.peek() < arr[i])
					stack.pop();
				
				if(stack.isEmpty())
					ans[i] = -1;
				else
					ans[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int[] ngr = ngr(arr);
		for(int ele : ngr)
			System.out.print(ele + " ");
		sc.close();
	}
}
