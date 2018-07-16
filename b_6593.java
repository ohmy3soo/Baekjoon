import java.io.*;
import java.util.*;

public class b_6593 {

	static int L, R, C, cost, ans;
	static char[][][] map;
	static int[][] dir = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
	static int sl=0, sr=0, sc=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0) break;

			map = new char[L][R][C];

			for(int l=0; l<L; l++) {
				for(int r=0; r<R; r++) {
					String line = in.readLine();
					for(int c=0; c<C; c++) {
						map[l][r][c] = line.charAt(c);
						if(map[l][r][c] == 'S') {
							sl = l;
							sr = r;
							sc = c;
						}
					}

				}
				in.readLine();
			}
			ans = Integer.MAX_VALUE;
			// dfs(sl, sr, sc);
			bfs(sl, sr, sc);
			if(ans == Integer.MAX_VALUE) sb.append("Trapped!\n");
			else sb.append("Escaped in " + ans + " minute(s).\n");
		}
		System.out.println(sb);
	}

	static void bfs(int a, int b, int c) {
		Queue<Pos> Q = new LinkedList<>();
		Q.add(new Pos(a,b,c));

		int update = Q.size();
		int cost = 0;
		int count = 0;
		while(!Q.isEmpty()) {
			if(count == update) {
				count = 0;
				update = Q.size();
				cost++;
			}

			Pos node = Q.poll();
			count++;
			a = node.a;
			b = node.b;
			c = node.c;
			if(map[a][b][c] == 'E') {
				ans = cost;
				return;
			}
			if(map[a][b][c] == '#') continue;

			map[a][b][c] = '#';
			for(int i=0; i<dir.length; i++) {
				int next_a = a + dir[i][0];
				int next_b = b + dir[i][1];
				int next_c = c + dir[i][2];

				if(next_a<0 || next_a>=L) continue;
				if(next_b<0 || next_b>=R) continue;
				if(next_c<0 || next_c>=C) continue;

				if(map[next_a][next_b][next_c] != '#')
					Q.add(new Pos(next_a, next_b, next_c));
			}
		}
	}

	static void dfs(int a, int b, int c) {

		System.out.println(a + " " + b + " " + c);
		if(map[a][b][c] == 'E') {
			ans = Math.min(ans, cost);
			return;
		}

		for(int i=0; i<dir.length; i++) {
			int next_a = a + dir[i][0];
			int next_b = b + dir[i][1];
			int next_c = c + dir[i][2];

			if(next_a<0 || next_a>=L) continue;
			if(next_b<0 || next_b>=R) continue;
			if(next_c<0 || next_c>=C) continue;
			map[a][b][c] = '#';
			if(map[next_a][next_b][next_c] != '#') {
				cost++;
				dfs(next_a, next_b, next_c);
				cost--;
			}
		}
	}
}
class Pos {
	int a, b, c;
	public Pos(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
