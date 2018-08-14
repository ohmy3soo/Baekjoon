package NetworkFlow;
import java.io.*;
import java.util.*;

public class b_11408 {
	
	static int[][] c, f, d;
	static int N, M, S, T, size;
	static ArrayList<Integer>[] arr;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = 0;
		T = N+M+1;
		size = N+M+2;
		c = new int[size][size];
		f = new int[size][size];
		d = new int[size][size];
		arr = new ArrayList[size];
		for(int i=0; i<size; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			c[S][i] = 1;
			arr[S].add(i);
			arr[i].add(S);
		}
		for(int i=N+1; i<=N+M; i++) {
			c[i][T] = 1;
			arr[i].add(T);
			arr[T].add(i);
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int j=0; j<K; j++) {
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				arr[i].add(N+to);
				arr[N+to].add(i);
				
				d[i][N+to] = cost;
				d[N+to][i] = -cost;
				
				c[i][N+to] = 1;
			}
		}
		
		int result = 0;
		int cnt = 0;
		while(true) {
			int[] pre, dist;
			pre = new int[size];
			dist = new int[size];
			
			boolean[] inQ = new boolean[size];
			
			Queue<Integer> Q = new LinkedList<>();
			Arrays.fill(pre, -1);
			Arrays.fill(dist, INF);
			
			dist[S] = 0;
			inQ[S] = true;
			Q.add(S);
			
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				inQ[cur] = false;
				
				for(int i=0; i<arr[cur].size(); i++) {
					int next = arr[cur].get(i);
					if(c[cur][next] - f[cur][next] > 0 && dist[next] > dist[cur] + d[cur][next]) {
						dist[next] = dist[cur] + d[cur][next];
						pre[next] = cur;
						if(!inQ[next]) {
							Q.add(next);
							inQ[next] = true;
						}
					}
				}
			}
			if(pre[T] == -1) break;
			
			int flow = INF;
			
			for(int i=T; i!=S; i=pre[i]) {
				flow = Math.min(flow, c[pre[i]][i] - f[pre[i]][i]);
			}
			for(int i=T; i!=S; i=pre[i]) {
				result += flow*d[pre[i]][i];
				f[pre[i]][i] += flow;
				f[i][pre[i]] -= flow;
			}
			cnt++;
		}
		sb.append(cnt+"\n"+result);
		System.out.println(sb);
	}

}