import java.io.*;
import java.util.*;

public class b_2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] score = new int[N+1];
		int[][] DP = new int[N+1][2];
		for(int i=1; i<=N; i++)
			score[i] = Integer.parseInt(in.readLine());

		DP[1][1] = score[1];
		DP[2][0] = score[2];
		DP[2][1] = score[1] + score[2];

		for(int i=3; i<=N; i++) {
			DP[i][0] = Math.max(DP[i-2][0], DP[i-2][1]) + score[i];
			DP[i][1] = DP[i-1][0] + score[i];
		}

		System.out.println(Math.max(DP[N][0], DP[N][1]));
	}
}
