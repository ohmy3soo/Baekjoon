import java.io.*;
import java.util.*;

public class b_10217 {

	static int N, M, K;
	static boolean[] visit;
	static ArrayList<Node>[] edge;
	static PriorityQueue<Node> pq;
	static int[][] min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			edge = new ArrayList[N+1];
			for(int i=1; i<N+1; i++)
				edge[i] = new ArrayList<>();
			min = new int[N+1][M+1];
			for(int i=0; i<N+1; i++) {
				for(int j=0; j<M+1; j++) {
					min[i][j] = Integer.MAX_VALUE;
				}
			}
			for(int m=0; m<K; m++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				edge[from].add(new Node(to, cost, time));
			}

			int ans = dij();
			if(ans == -1)
				sb.append("Poor KCM");
			else
				sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int dij() {
		pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.time - o2.time;
			}
		});

		pq.add(new Node(1, 0, 0));

		while(true) {
			if(pq.size() == 0)
				return -1;
			Node temp = pq.poll();
			if(temp.to == N)
				return temp.time;

			for(int i=0; i<edge[temp.to].size(); i++) {
				Node next = edge[temp.to].get(i);
				if(next.to == 1)
					continue;
				if(temp.cost+next.cost <= M) {
					if(min[next.to][temp.cost+next.cost] > temp.time+next.time) {
						min[next.to][temp.cost+next.cost] = temp.time+next.time;
						pq.add(new Node(next.to, temp.cost+next.cost, temp.time+next.time));
					}
				}
			}
		}
	}
}
class Node {
	int to;
	int cost;
	int time;

	public Node(int to, int c, int d) {
		this.to = to;
		this.cost = c;
		this.time = d;
	}
}
