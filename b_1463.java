import java.io.*;
import java.util.*;

public class b_1463 {
	static int[] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		DP = new int[N+1];

		search(N);
		System.out.println(DP[1]);
	}
	static void search(int n) {
		if(n==0)
			return;
		if(n%3 == 0 && (DP[n/3] > DP[n] + 1 || DP[n/3] == 0) ) {
			DP[n/3] = DP[n] + 1;
			search(n/3);
		}
		if(n%2 == 0 && (DP[n/2] > DP[n] + 1 || DP[n/2] == 0) ) {
			DP[n/2] = DP[n] + 1;
			search(n/2);
		}
		if(DP[n-1] > DP[n] + 1 || DP[n-1] == 0) {
			DP[n-1] = DP[n] +1;
			search(n-1);
		}
	}
}
