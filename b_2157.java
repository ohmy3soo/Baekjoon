package NA2_2;
import java.io.*;
import java.util.*;

public class b_2157 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = new ArrayList<>();
		int[][] DP = new int[N+1][M+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a>b)
				continue;
			arr[a].add(new Node(b,c));
		}
		
		for(int i=0; i<arr[1].size(); i++)
			DP[arr[1].get(i).to][2] = Math.max(DP[arr[1].get(i).to][2], arr[1].get(i).score);
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<arr[i].size(); j++) {
				int to = arr[i].get(j).to;
				int score = arr[i].get(j).score;
				for(int t=2; t<M; t++) {
					if(DP[i][t] != 0)
						DP[to][t+1] = Math.max(DP[to][t+1], DP[i][t] + score); 
				}
			}
		}
		int ans = 0;
		for(int i=0; i<=M; i++)
			ans = Math.max(ans, DP[N][i]);
		System.out.println(ans);
	}
}
class Node {
	int to;
	int score;
	public Node (int t, int s) {
		this.to = t;
		this.score = s;
	}
}