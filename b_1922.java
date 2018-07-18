package NA8_1;
import java.io.*;
import java.util.*;

public class b_1922 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		p = new int[N+1];
		Arrays.fill(p, -1);
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int ans = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Node next = pq.poll();
			if(merge(next.a, next.b)) {
				ans += next.cost;
				if(++count == N-1) break;
			}
		}
		
		System.out.println(ans);
		
	}
	static int find(int n) {
		if(p[n] < 0) return n;
		return p[n] = find(p[n]);
	}
	static boolean merge(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		p[a] += p[b];
		p[b] = a;
		return true;
	}
}

/*
class Node {
	int a, b, cost;
	public Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.cost = c;
	}
}
*/
