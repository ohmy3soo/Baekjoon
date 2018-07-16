import java.io.*;
import java.util.*;

public class b_2042 {
	static long[] arr;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		tree = new long[1<<h];
		init(1, N, 1);
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				update(1, N, 1, c-arr[b], b);
				arr[b] = c;
			}
			else
				sb.append(sum(b, c, 1, N, 1)+"\n");
		}
		System.out.println(sb);
	}
	
	static long init(int L, int R, int idx) {
		if(L==R) return tree[idx] = arr[L];
		else {
			return tree[idx] = init(L, (L+R)/2, 2*idx) + init((L+R)/2+1, R, 2*idx+1);
		}
	}
	
	static void update(int L, int R, int idx, long val, int node) {
		tree[idx] += val;
		if(L==R) return;
		if((L+R)/2 < node) update((L+R)/2+1, R, 2*idx+1, val, node);
		else update(L, (L+R)/2, 2*idx, val, node);
	}
	
	static long sum(int sL, int sR, int L, int R, int idx) {
		if(sL > R || sR < L) return 0;
		if(sL <= L && sR >= R) return tree[idx];
		return sum(sL, sR, L, (L+R)/2, 2*idx) + sum(sL, sR, (L+R)/2+1, R, 2*idx+1);
	}
}
