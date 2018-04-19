import java.util.*;

public class b_2170 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				return Integer.compare(arr1[0], arr2[0]);
			}
		});
		
		int length = arr[0][1] - arr[0][0];
		int index = arr[0][1];
		for(int i=1; i<arr.length; i++) {
			if(arr[i][0] < index) {
				if(arr[i][1] > index) {
					length += arr[i][1] - index;
					index = arr[i][1];
				}
				else
					continue;
			}
			else {
				index = arr[i][1];
				length += arr[i][1] - arr[i][0];
			}
		}
		System.out.println(length);
		
	}
}
