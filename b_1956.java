package NA8_1;
import java.io.*;
import java.util.*;

public class b_1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] edge = new int[V+1][V+1];
		int INF = 10_000 * V * (V-1) + 1;
		for(int i=1; i<=V; i++)
			Arrays.fill(edge[i], INF);
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge[a][b] = c;
		}
		
		for(int m=1; m<=V; m++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(edge[i][m] != INF && edge[m][j] != INF)
						edge[i][j] = Math.min(edge[i][j], edge[i][m] + edge[m][j]);
				}
			}
		}
		
		int ans = INF;
		for(int i=1; i<=V; i++)
			ans = Math.min(ans, edge[i][i]);
		if(ans == INF) System.out.println(-1);
		else System.out.println(ans);
	}
}
