import java.io.*;
import java.util.*;

public class b_4963 {
	static int w,h;
	static int[][] map;
	static boolean[][] visit;
	static int[][] move = { {-1,0}, {0,1}, {1,0}, {0,-1}, {-1,-1}, {-1,1}, {1,1}, {1,-1} };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit = new boolean[h][w];
			int ans = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && visit[i][j] == false) {
						bfs(i, j);
						ans++;
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	static void bfs(int m, int n) {
		visit[m][n] = true;
		for(int i=0; i<move.length; i++) {
			int next_m = m+move[i][0];
			int next_n = n+move[i][1];
			if(next_m >= 0 && next_m < h && next_n >=0 && next_n < w) {
				if(map[next_m][next_n] == 1 && visit[next_m][next_n] == false) {
					bfs(next_m, next_n);
				}
			}
		}
	}
}
