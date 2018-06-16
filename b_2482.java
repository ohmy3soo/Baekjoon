package p15;
import java.io.*;

public class b_2482 {
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		
		DP = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			DP[i][1] = i;
			DP[i][0] = 1;
		}
		
		for(int i=2; i<N; i++)
			for(int j=2; j<=K; j++)
				DP[i][j] = (DP[i-2][j-1] + DP[i-1][j]) % 1000000003;
		
		System.out.println((DP[N-3][K-1] + DP[N-1][K]) % 1000000003);
	}
}
