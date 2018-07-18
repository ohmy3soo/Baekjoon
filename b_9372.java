package NA8_1;
import java.io.*;
import java.util.*;

public class b_9372 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			Arrays.fill(p, -1);
			
			Stack<Node> S = new Stack<>();
			int M = Integer.parseInt(st.nextToken());
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				S.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			int ans = 0, count = 0;
			while(!S.isEmpty()) {
				Node next = S.pop();
				if(merge(next.a, next.b)) {
					ans++;
					if(++count == N-1) break;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
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
	int a, b;
	public Node(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
*/