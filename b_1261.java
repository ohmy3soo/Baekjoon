package NA8_1;
import java.io.*;
import java.util.*;

public class b_1261 {
	
	static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	static int[][] map;
	static boolean[][] visit;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for(int i=0; i<M; i++) {
			String input = in.readLine();
			for(int j=0; j<N; j++)
				map[i][j] = input.charAt(j)-'0';
		}
		visit = new boolean[M][N];
		System.out.println(dij(0,0));
	}
	static int dij(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		
		pq.add(new Node(x,y,0));
		
		while(!pq.isEmpty()) {
			Node next = pq.poll();
			
			if(visit[next.x][next.y] == true) continue;
			visit[next.x][next.y] = true;
			if(next.x == M-1 && next.y == N-1) return next.cost;
			
			for(int i=0; i<dir.length; i++) {
				int next_x = next.x+dir[i][0];
				int next_y = next.y+dir[i][1];
				if(next_x >= 0 && next_x<M && next_y >=0 && next_y<N) {
					pq.add(new Node(next_x, next_y, next.cost+map[next_x][next_y]));
				}
			}
		}
		return -1;
	}
}
/*
class Node {
	int x, y, cost;
	public Node(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.cost = c;
	}
}
*/
