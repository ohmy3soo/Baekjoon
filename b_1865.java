package Bellman;
import java.io.*;
import java.util.*;

public class b_1865 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(in.readLine());
		
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			ArrayList<Node> arr[] = new ArrayList[N+1];
			for(int i=1; i<=N; i++)
				arr[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				arr[S].add(new Node(E, T));
				arr[E].add(new Node(S, T));
			}
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(in.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				arr[S].add(new Node(E, -T));
			}
			
			int INF = M * 10_000 + 1;
			int[] dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			dist[1] = 0;
			boolean possible = false;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					for(int s=0; s<arr[j].size(); s++) {
						if(dist[j] != INF && dist[arr[j].get(s).to] > dist[j] + arr[j].get(s).cost) {
							dist[arr[j].get(s).to] = dist[j] + arr[j].get(s).cost;
							if(i==N) possible = true;
						}
					}
				}
			}
			if(possible) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
}

class Node {
	int to;
	int cost;
	public Node(int t, int c) {
		this.to = t;
		this.cost = c;
	}
}
