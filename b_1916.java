package Dijkstra;
import java.io.*;
import java.util.*;

public class b_1916 {
	
	static ArrayList<Node>[] arr;
	static boolean[] visit;
	static int[] dist;
	static final int INF = 100_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[from].add(new Node(to, cost));
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		dij(start);
		
		System.out.println(dist[end]);
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
			int cost = next.cost;
			
			if(visit[to] == true) continue;
			visit[to] = true;
			for(int i=0; i<arr[to].size(); i++) {
				if(dist[arr[to].get(i).to] > cost + arr[to].get(i).cost) {
					dist[arr[to].get(i).to] = cost + arr[to].get(i).cost;
					pq.add(new Node(arr[to].get(i).to, dist[arr[to].get(i).to]));
				}
			}
		}
	}
	
}

/*
class Node {
	int to;
	int cost;
	public Node(int t, int c) {
		this.to = t;
		this.cost = c;
	}
}
*/