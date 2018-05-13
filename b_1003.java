import java.io.*;
import java.util.*;

public class b_1003 {

	static int[][] DP;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		DP = new int[41][2];
		visit = new boolean[41];

		DP[0][0] = 1;
		DP[0][1] = 0;
		visit[0] = true;
		DP[1][0] = 0;
		DP[1][1] = 1;
		visit[1] = true;

		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(in.readLine());
			DP[N] = getCount(N);
			sb.append(DP[N][0] +" "+ DP[N][1] +"\n");
		}
		System.out.println(sb);
	}

	public static int[] getCount(int n) {
		if(visit[n] == true)
			return DP[n];
		DP[n][0] = getCount(n-1)[0] + getCount(n-2)[0];
		DP[n][1] = getCount(n-1)[1] + getCount(n-2)[1];
		visit[n] = true;
		return DP[n];
	}
}
