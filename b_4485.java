import java.io.*;
import java.util.*;

public class b_4485 {
	static int N;
	static int[][] map, cost;
	static boolean[][] visit;
	static int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static final int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=1; ; t++) {
			N = Integer.parseInt(in.readLine());
			if(N==0)
				break;

			map = new int[N][N];
			cost = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cost[i][j] = MAX;
				}
			}

			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			String ans = "Problem " + t + ": " + dij() +"\n";
			sb.append(ans);
		}
		System.out.println(sb);
	}
	public static int dij() {

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});

		pq.add(new Node(map[0][0], 0, 0));
		while(true) {
			Node temp = pq.poll();
			if(temp.x == N-1 && temp.y == N-1)
				return temp.cost;
			visit[temp.x][temp.y] = true;
			cost[temp.x][temp.y] = temp.cost;
			for(int i=0; i<move.length; i++) {
				int new_x = temp.x+move[i][0];
				int new_y = temp.y+move[i][1];
				if(new_x<N && new_y<N && new_x>=0 && new_y>=0 && temp.cost+map[new_x][new_y] < cost[new_x][new_y] && visit[new_x][new_y] == false) {
					pq.add(new Node(temp.cost+map[new_x][new_y], new_x, new_y));
				}
			}
		}
	}
}
class Node {
	int cost;
	int x,y;
	public Node(int c, int x, int y) {
		this.cost = c;
		this.x = x;
		this.y = y;
	}
}
