import java.util.*;

public class b_2468 {
	static int N;
	static final int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		Set<Integer> S = new HashSet<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				S.add(map[i][j]);
			}
		}

		int maxLand = 1;
		Iterator I = S.iterator();
		while(I.hasNext()) {
			int land = bfs(map, N, (int)I.next());
			if(land > maxLand)
				maxLand = land;
		}
		System.out.println(maxLand);
	}

	public static int bfs(int[][] arr, int n, int h) {
		int count = 0;
		int[][] map = arr.clone();

		Queue<int[]> Q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j] > h) {
					Q.offer(new int[]{i,j});
					visited[i][j] = true;
					while(!Q.isEmpty()) {
						int[] pos = Q.poll();
						for(int d=0; d<dir.length; d++) {
							int[] next = new int[] { pos[0]+dir[d][0] , pos[1]+dir[d][1] };
							if(0<=next[0] && next[0]<n && 0<=next[1] && next[1]<n) {
								if(!visited[next[0]][next[1]] && map[next[0]][next[1]] > h) {
									Q.offer(next);
									visited[next[0]][next[1]] = true;
								}
							}
						}
					}
					count++;
				}
			}
		}
		return count;
	}
}
