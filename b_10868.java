import java.io.*;
import java.util.*;

public class b_10868 {
	static int[] arr, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		
		int h = (int)Math.ceil(Math.log(N) / Math.log(2))+1;
		tree = new int[1<<h];
		init(1, N, 1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(search(a,b,1,N,1) + "\n");
		}
		System.out.println(sb);
	}
	static int init(int L, int R, int idx) {
		if(L==R) return tree[idx] = arr[L];
		return tree[idx] = Math.min(init(L, (L+R)/2, 2*idx), init((L+R)/2+1, R, 2*idx+1));
	}
	static int search(int sl, int sr, int L, int R, int idx) {
		if(sl>R || L>sr) return Integer.MAX_VALUE;
		if(sl<=L && sr>=R) return tree[idx];
		return Math.min(search(sl, sr, L, (L+R)/2, 2*idx), search(sl, sr, (L+R)/2+1, R, 2*idx+1));
	}
}
