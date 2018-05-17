import java.io.*;
import java.util.*;

public class b_11066 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		int[][] DP;

		StringTokenizer st;
		for(int i=0; i<T; i++) {
			int K = Integer.parseInt(in.readLine());
			DP = new int[K+1][K+1];
			int[] arr = new int[K+1];
			int[] sum = new int[K+1];

			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=K; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + arr[j];
			}
			for(int j=1; j<K; j++)
				DP[j][j+1] = arr[j] + arr[j+1];

			for(int l=2; l<K; l++) {
				for(int m=1; m<=K-l; m++) {
					DP[m][m+l] = Integer.MAX_VALUE;
					for(int n=m; n<m+l; n++) {
						DP[m][m+l] = Math.min(DP[m][m+l], DP[m][n] + DP[n+1][m+l] + sum[m+l]-sum[m-1]);
					}
				}
			}

			sb.append(DP[1][K] + "\n");
		}

		System.out.println(sb);
	}
}
