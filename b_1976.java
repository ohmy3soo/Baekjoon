package UnionFind;
import java.io.*;
import java.util.*;

public class b_1976 {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		p = new int[N+1];
		Arrays.fill(p, -1);
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				int flag = Integer.parseInt(st.nextToken());
				if(flag == 1)
					merge(i,j);
			}
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int city = find(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			int next = find(Integer.parseInt(st.nextToken()));
			if(city != next) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	static int find(int n) {
		if(p[n]<0) return n;
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
