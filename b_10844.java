import java.io.*;
import java.util.*;

public class b_10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[][] DP = new int[N+1][10];
		for(int i=1; i<10; i++)
			DP[1][i] = 1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if(j>0)
					DP[i][j] += DP[i-1][j-1];
				if(j<9)
					DP[i][j] += DP[i-1][j+1];
				DP[i][j] %= 1000000000;
			}
		}

		int ans = 0;
		for(int i=0; i<10; i++) {
			ans += DP[N][i];
			ans %= 1000000000;
		}
		System.out.println(ans);

	}
}
