import java.util.*;

public class b_10871 {
	public static void main(String[] args) {
		int N, X;
		int temp;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();


		// 공간복잡도 O(1)
		for(int i=0; i<N; i++) {
			temp = sc.nextInt();
			if(temp < X)
				System.out.printf(temp + " ");
		}
	}
}
