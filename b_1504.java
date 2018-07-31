package Dijkstra;
import java.io.*;
import java.util.*;

public class b_1504 {
	
	static ArrayList<Node>[] arr;
	static int N;
	static final int INF = 200_000_001;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));
		}
		
		st = new StringTokenizer(in.readLine());
		int mid1 = Integer.parseInt(st.nextToken());
		int mid2 = Integer.parseInt(st.nextToken());
		
		long ans1 = (long)getDist(1, mid1) + getDist(mid1, mid2) + getDist(mid2, N);
		long ans2 = (long)getDist(1, mid2) + getDist(mid2, mid1) + getDist(mid1, N);
		
		if(flag) System.out.println(Math.min(ans1, ans2));
		else System.out.println(-1);
	}
	static int getDist(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		boolean[] visit = new boolean[N+1];
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
			if(to == end) return cost;
			for(int i=0; i<arr[to].size(); i++) {
				if(dist[arr[to].get(i).to] > cost + arr[to].get(i).cost) {
					dist[arr[to].get(i).to] = cost + arr[to].get(i).cost;
					pq.add(new Node(arr[to].get(i).to, dist[arr[to].get(i).to]));
				}
			}
			
		}
		flag = false;
		return -1;
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