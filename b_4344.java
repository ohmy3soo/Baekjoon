import java.util.*;

public class b_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();

		for(int i=0; i<C; i++) {
			int t = sc.nextInt();
			int[] arr = new int[t];
			int sum=0;
			int count=0;
			for(int j=0; j<t; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			for(int j=0; j<t; j++) {
				if(arr[j] > sum/t)
					count++;
			}

			System.out.printf("%.3f%%\n",(double)count/t*100);

		}
	}
}
