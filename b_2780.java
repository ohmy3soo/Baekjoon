import java.io.*;

public class b_2780 {

	static int[][] next = { {7}, {2,4}, {1,3,5}, {2,6}, {1,5,7},
							{2,4,6,8}, {3,5,9}, {0,4,8}, {5,7,9}, {6,8} };
	// x부터 y번 더 갈 수 있는 수
	static int[][] DP = new int[10][1001];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<10; i++)
			DP[i][0] = 1;

		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(in.readLine());
			int ans = 0;

			for(int i=0; i<10; i++)
				ans += goNext(i, N-1);
			ans %= 1234567;
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	static int goNext(int n, int r) {
		int ret = DP[n][r];
		if(ret != 0) return ret;
		else {
			for(int i=0; i<next[n].length; i++)
				ret += goNext(next[n][i], r-1)%1234567;
		}
		DP[n][r] = ret%1234567;
		return DP[n][r];
	}
}
