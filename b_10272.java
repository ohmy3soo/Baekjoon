package p25;
import java.io.*;
import java.util.*;

public class b_10272 {
	
	static Node_10272[] arr;
	static double[][] DP;
	static int N, INF=Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(in.readLine());
			arr = new Node_10272[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				arr[i] = new Node_10272(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			DP = new double[N][N];
			for(int i=0; i<N; i++)
				Arrays.fill(DP[i], INF);

			double ans = solve(0,0);
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		
	}
	static double solve(int f, int b) {
		if(DP[f][b] != INF) return DP[f][b];
		int next = Math.max(f, b) + 1;
		if(next == N-1) return getDist(f, next) + getDist(b, next);
		return DP[f][b] = Math.min(solve(next, b) + getDist(f, next), solve(f, next) + getDist(b, next));
	}
	static double getDist(int a, int b) {
		return Math.sqrt((arr[a].x - arr[b].x)*(arr[a].x - arr[b].x) 
				+ (arr[a].y - arr[b].y)*(arr[a].y - arr[b].y));
	}
}

class Node_10272 {
	int x, y;
	boolean visit;
	public Node_10272(int x, int y) {
		this.x = x;
		this.y = y;
		this.visit = false;
	}
}