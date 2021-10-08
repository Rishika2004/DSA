package array_1D;

public class P14_MaximumSumCircularSubarray {

	public static void main(String[] args) {
		
		int arr[] = {-2, 2, 3, -6, 8};
		int ans = maxSumCircularSubarray(arr); // ans = 11
		System.out.println(ans);
	}
	
	public static int maxSumCircularSubarray(int[] arr) {

		// Case 1 : contributing elements are non wrapping
		// This case : -1 2 3 5 -3
		int ceNotWrapping = kadane(arr);

		// Case 2 : contributing elements are wrapping
		// This case : -2 2 3 -6 8
		int totalSum = 0;

		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
			arr[i] = -arr[i];
		}

		int nonContributingElementSum = kadane(arr);

		int ceWrapping = totalSum + nonContributingElementSum;

		return Math.max(ceNotWrapping, ceWrapping);

	}
	
	public static int kadane(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum > max)
				max = sum;
		}

		return max;

	}
}
