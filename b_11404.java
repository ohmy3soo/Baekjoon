import java.io.*;
import java.util.*;

public class b_11404 {
	
	static int[][] map;
	static boolean[][] visit;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		
		map = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(map[s-1][e-1] == 0 || map[s-1][e-1] > c)
				map[s-1][e-1] = c;
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i==j)
						continue;
					if(map[i][k] == 0 || map[k][j] == 0)
						continue;
					if(map[i][j] > map[i][k] + map[k][j] || map[i][j] == 0)
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
		
}