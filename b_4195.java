package p13;
import java.io.*;
import java.util.*;

public class b_4195 {
	
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int i=0; i<T; i++) {
			int F = Integer.parseInt(in.readLine());
			int idx = 0;
			p = new int[F*2+1];
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(int j=0; j<F; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				if(!hm.containsKey(f1)) {
					hm.put(f1, ++idx);
					p[idx] = -1;
				}
				if(!hm.containsKey(f2)) {
					hm.put(f2, ++idx);
					p[idx] = -1;
				}
				
				connect(hm.get(f1), hm.get(f2));
				
				sb.append(-p[find(hm.get(f1))] +"\n");
			}
			
		}
		System.out.println(sb);
	}
	public static void connect(int a, int b) {
		a = find(a);
		b = find(b);

		if(a != b) {
			p[a] += p[b];
			p[b] = a;
		}
	}
	
	public static int find(int n) {
		if(p[n] < 0) return n;
		p[n] = find(p[n]);
		return p[n];
	}
}
