import java.io.*;
import java.util.*;

public class b_11657 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] edge = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			edge[i] = new ArrayList<>();
			
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edge[A].add(new Edge(B,C));
		}
		
		int INF = N * 10000;
		int[] map = new int[N+1];
		Arrays.fill(map, INF);
		
		map[1] = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=0; k<edge[j].size(); k++) {
					int to = edge[j].get(k).to;
					int cost = edge[j].get(k).cost;
					if(map[j] != INF && map[to] > map[j] + cost) {
						map[to] = map[j] + cost;
						if(i == N) {
							System.out.println(-1);
							return;
						}
					}
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			int val = (map[i] == INF)? -1 : map[i];
			sb.append(val+"\n");
		}
		System.out.println(sb);
	}
}
class Edge {
	int to;
	int cost;
	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}