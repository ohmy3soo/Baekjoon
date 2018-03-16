import java.util.*;

public class b_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() * sc.nextInt() * sc.nextInt();
		int[] arr = new int[10];

		while(N>0) {
			arr[N%10]++;
			N /= 10;
		}
		for(int i=0; i<10; i++)
			System.out.println(arr[i]);
	}
}
