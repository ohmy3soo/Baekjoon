import java.util.*;
import java.io.*;

public class b_11403 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++)
			dfs(i, i);
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]+ " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static void dfs(int s, int v) {
		for(int i=0; i<N; i++) {
			if(map[v][i] == 1 && visit[s][i] == false) {
				map[s][i] = 1;
				visit[s][i] = true;
				dfs(s, i);
			}
		}
	}
}

