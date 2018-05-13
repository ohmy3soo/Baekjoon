import java.io.*;
import java.util.*;

public class b_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] v = new int[n][n];
		int[][] DP = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<=i; j++) {
				v[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DP[0][0] = v[0][0];
		for(int i=1; i<n; i++) {
			DP[i][0] = DP[i-1][0] + v[i][0];
			for(int j=1; j<i; j++)
				DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + v[i][j];
			DP[i][i] = DP[i-1][i-1] + v[i][i];
		}

		int ans = 0;
		for(int i=0; i<n; i++)
			ans = Math.max(ans, DP[n-1][i]);
		System.out.println(ans);
	}
}
