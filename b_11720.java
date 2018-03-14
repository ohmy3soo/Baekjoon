import java.util.*;

public class b_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		String input = sc.next();
		for(int i=0; i<N; i++) {
			arr[i] = input.charAt(N-i-1) - '0';
		}
		for(int i=0; i<N; i++)
			sum += arr[i];
		System.out.println(sum);
	}
}
