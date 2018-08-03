package UnionFind;
import java.io.*;
import java.util.*;

public class b_1717 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		Arrays.fill(p, -1);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int method = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(method == 0)
				merge(a, b);
			else {
				if(find(a) == find(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
		
	}
	static int find(int n) {
		if(p[n] < 0) return n;
		return p[n] = find(p[n]);
	}
	
	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		p[a] += p[b];
		p[b] = a;
	}
}

