import java.io.*;
import java.util.*;

public class b_9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(in.readLine());

			int[][] map = new int[2][n];
			int[][] DP = new int[2][n];

			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DP[0][0] = map[0][0];
			DP[1][0] = map[1][0];
			DP[0][1] = DP[1][0] + map[0][1];
			DP[1][1] = DP[0][0] + map[1][1];

			for(int j=2; j<n; j++) {
				for(int i=0; i<2; i++)
					DP[i][j] = Math.max(DP[1-i][j-1], Math.max(DP[0][j-2], DP[1][j-2])) + map[i][j];
			}

			sb.append(Math.max(DP[0][n-1], DP[1][n-1])+"\n");

		}
		System.out.println(sb);

	}
}
