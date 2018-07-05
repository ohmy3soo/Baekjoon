import java.io.*;
import java.util.*;

public class b_13565 {
	static int[][] dir = { {-1,0}, {0,1}, {0,-1}, {1,0} };
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String input = in.readLine();
			for(int j=0; j<N; j++)
				map[i][j] = (input.charAt(j) == '1')? true : false;
		}
		
		for(int i=0; i<N; i++) {
			if(map[M-1][i]==false) {
				map[M-1][i] = true;
				boolean ans = DFS(M-1, i);
				if(ans) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
		
	}
	static boolean DFS(int y, int x) {
		if(y == 0) return true;
		
		for(int i=0; i<dir.length; i++) {
			int next_y = y+dir[i][0];
			int next_x = x+dir[i][1];
			if(next_x<0 || next_x>=map[0].length || next_y<0 || next_y>=map.length) continue;
			if(map[next_y][next_x] == true) continue;
			
			map[next_y][next_x] = true;
			if(DFS(next_y, next_x)) return true;
		}
		return false;
	}
}
