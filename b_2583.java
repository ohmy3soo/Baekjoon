import java.util.*;

public class b_2583 {
	static int M;
	static int N;
	static boolean[][] map;
	static Queue<int[]> Q = new LinkedList<>();
	static ArrayList<Integer> s = new ArrayList<>();
	static int[][] dir = { {-1,0} , {1,0}, {0,-1}, {0,1} };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new boolean[M][N];

		int K = sc.nextInt();

		for(int i=0; i<K; i++) {
			int lb_x = sc.nextInt();
			int lb_y = sc.nextInt();
			int rt_x = sc.nextInt();
			int rt_y = sc.nextInt();

			for(int x=lb_x; x<rt_x; x++)
				for(int y=lb_y; y<rt_y; y++)
					map[y][x] = true;
		}

		bfs();

		System.out.println(s.size());
		Collections.sort(s);
		for(int i=0; i<s.size(); i++)
			System.out.print(s.get(i) + " ");
	}

	public static void bfs() {
		for(int y=0; y<M; y++) {		// y축
			for(int x=0; x<N; x++) {		// x축
				int space = 0;
				if(map[y][x] != true) {
					Q.offer(new int[] {y,x});
					space++;
					map[y][x] = true;
					while(!Q.isEmpty()) {
						int[] pos = Q.poll();
						for(int d=0; d<dir.length; d++) {
							int[] next = new int[] { pos[0]+dir[d][0], pos[1]+dir[d][1] };
							if(0<=next[0] && next[0]<M && 0<=next[1] && next[1]<N) {
								if(map[next[0]][next[1]] != true) {
									Q.offer(next);
									space++;
									map[next[0]][next[1]] = true;
								}
							}
						}
					}
				}
				if(space != 0)
					s.add(space);
			}
		}
	}
}
