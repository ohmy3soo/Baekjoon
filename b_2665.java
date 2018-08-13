import java.io.*;
import java.util.*;

public class b_2665 {
	static int n;
	static char[][] map;
	static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		map = new char[n][n];

		for(int i=0; i<n; i++) {
			String input = in.readLine();
			for(int j=0; j<n; j++)
				map[i][j] = input.charAt(j);
		}

		System.out.println(dij());
	}
	static int dij() {
		PriorityQueue<Node_2665> pq = new PriorityQueue<>(new Comparator<Node_2665>() {
			@Override
			public int compare(Node_2665 o1, Node_2665 o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		pq.add(new Node_2665(0, 0, 0));

		boolean[][] visit = new boolean[n][n];
		while(!pq.isEmpty()) {
			Node_2665 cur = pq.poll();
			int y = cur.y;
			int x = cur.x;
			int cost = cur.cost;

			if(visit[y][x] == true) continue;
			visit[y][x] = true;

			if(y==n-1 && x==n-1) return cost;

			for(int i=0; i<dir.length; i++) {
				int next_y = y+dir[i][0];
				int next_x = x+dir[i][1];
				if(next_y>=0 && next_y<n && next_x>=0 && next_x<n) {
					if(map[next_y][next_x] == '1') pq.add(new Node_2665(next_y, next_x, cost));
					else pq.add(new Node_2665(next_y, next_x, cost+1));
				}
			}

		}

		return -1;
	}
}
class Node_2665 {
	int y, x, cost;
	public Node_2665(int y, int x, int c) {
		this.y = y;
		this.x = x;
		this.cost = c;
	}
}
