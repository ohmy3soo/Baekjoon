import java.io.*;
import java.util.*;

public class b_1520 {
	static int M,N;
	static int[][] map, DP;
	static boolean[][] visit;
	static int[][] dir = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		DP = new int[M][N];
		visit = new boolean[M][N];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		DP[M-1][N-1] = 1;
		visit[M-1][N-1] = true;
		DFS(0,0);

		System.out.println(DP[0][0]);

	}
	static void DFS(int x, int y) {

		int ans = 0;
		for(int i=0; i<dir.length; i++) {
			int next_x = x+dir[i][0];
			int next_y = y+dir[i][1];

			if( next_x>=0 && next_x<M && next_y>=0 && next_y<N) {
				if(map[next_x][next_y] < map[x][y]) {
					if(visit[next_x][next_y] == false)
						DFS(next_x, next_y);
					ans += DP[next_x][next_y];
				}
			}
		}
		DP[x][y] = ans;
		visit[x][y] = true;
	}
}
