package Dijkstra;
import java.io.*;
import java.util.*;

public class b_1753 {

	static boolean[] visit;
	static int[] dist;
	static ArrayList<Node>[] arr;
	static final int INF = 3_000_001;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(in.readLine());
		
		arr = new ArrayList[V+1];
		for(int i=1; i<=V; i++)
			arr[i] = new ArrayList<Node>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Node(v, w));
		}
		
		
		visit = new boolean[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dist[K] = 0;
		dij(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void dij(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node next = pq.poll();
			int to = next.to;
			int d = next.cost;

			if(visit[to] == true) continue;
			visit[to] = true;
			for(int i=0; i<arr[to].size(); i++) {
				if(dist[arr[to].get(i).to] > d + arr[to].get(i).cost) {
					dist[arr[to].get(i).to] = d + arr[to].get(i).cost;
					pq.add(new Node(arr[to].get(i).to, dist[arr[to].get(i).to]));
				}
			}
		}
		
	}
}


class Node {
	int to;
	int cost;
	public Node(int t, int c) {
		this.to = t;
		this.cost = c;
	}
}