package Floyd;
import java.io.*;
import java.util.*;

public class b_1613 {
	
	static final int INF = 400;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		for(int i=1; i<=n; i++)
			Arrays.fill(map[i], INF);
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
		}
		
		for(int m=1; m<=n; m++) 
			for(int i=1; i<=n; i++)
				for(int j=1; j<=n; j++)
					map[i][j] = Math.min(map[i][j], map[i][m] + map[m][j]);
		
		int s = Integer.parseInt(in.readLine());
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(map[a][b] == INF && map[b][a] == INF) sb.append(0);
			else if(map[a][b] == INF) sb.append(1);
			else sb.append(-1);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
