import java.io.*;
import java.util.*;

public class b_1987 {

	static int R, C, ans = 0;
	static char[][] map;
	static boolean[] visit = new boolean['Z'-'A'+1];
	static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String input = in.readLine();
			for(int j=0; j<C; j++)
				map[i][j] = input.charAt(j);
		}

		visit[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	static void dfs(int y, int x, int count) {

		for(int i=0; i<dir.length; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny>=0 && ny<R && nx>=0 && nx<C && visit[map[ny][nx]-'A'] == false) {
				visit[map[ny][nx]-'A'] = true;
				dfs(ny, nx, count+1);
				visit[map[ny][nx]-'A'] = false;
			}
		}
		ans = Math.max(ans, count);
	}
}
