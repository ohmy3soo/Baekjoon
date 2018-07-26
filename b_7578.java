import java.io.*;
import java.util.*;

public class b_7578 {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		tree = new long[1<<h];

		HashMap<Integer, Integer> hm = new HashMap<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++)
			hm.put(Integer.parseInt(st.nextToken()), i);

		long ans = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			int from = Integer.parseInt(st.nextToken());
			int to = hm.get(from);
			ans += sum(to, N, 1, N, 1);
			update(1, N, 1, to, 1);
		}
		System.out.println(ans);
	}
	static long sum(int sl, int sr, int L, int R, int idx) {
		if(sl>R || sr<L) return 0;
		if(sl<=L && sr>=R) return tree[idx];
		return sum(sl, sr, L, (L+R)/2, 2*idx) + sum(sl, sr, (L+R)/2+1, R, 2*idx+1);
	}

	static void update(int L, int R, int idx, int node, int val) {
		tree[idx] += val;
		if(L==R) return;
		if((L+R)/2 < node) update((L+R)/2+1, R, 2*idx+1, node, val);
		else update(L, (L+R)/2, 2*idx, node, val);
	}

}
