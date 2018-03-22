import java.util.*;

public class b_2720 {
	public static void main(String[] args) {
		final int Q = 25;
		final int D = 10;
		final int N = 5;
		final int P = 1;

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int C = sc.nextInt();
			System.out.print(C/Q + " ");
			C %= Q;
			System.out.print(C/D + " ");
			C %= D;
			System.out.print(C/N + " ");
			C %= N;
			System.out.println(C/P);
		}
	}
}
