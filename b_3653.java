import java.io.*;
import java.util.*;

public class b_3653 {

	static int[] arr, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int C = Integer.parseInt(in.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int size = n+m;
			arr = new int[size+1];
			int h = (int)Math.ceil(Math.log(size) / Math.log(2)) + 1;
			tree = new int[1<<h];

			int[] pos = new int[n+1];
			for(int i=1; i<=n; i++) {
				pos[i] = m+i;
				arr[m+i] = 1;
			}

			init(1, size, 1);
			int top = m;
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<m; i++) {
				int num = Integer.parseInt(st.nextToken());
				int idx = pos[num];
				update(1, size, 1, idx, -1);
				sb.append(sum(1, idx, 1, size, 1) + " ");
				pos[num] = top;
				update(1, size, 1, top, 1);
				top--;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int init(int L, int R, int idx) {
		if(L==R) return tree[idx] = arr[L];
		return tree[idx] = init(L, (L+R)/2, 2*idx) + init((L+R)/2+1, R, 2*idx+1);
	}
	static int sum(int sl, int sr, int L, int R, int idx) {
		if(sl > R || sr < L) return 0;
		if(sl <= L && sr >= R) return tree[idx];
		return sum(sl, sr, L, (L+R)/2, 2*idx) + sum(sl, sr, (L+R)/2+1, R, 2*idx+1);
	}
	static void update(int L, int R, int idx, int node, int val) {
		tree[idx] += val;
		if(L == R) return;
		if((L+R)/2 < node) update((L+R)/2+1, R, 2*idx+1, node, val);
		else update(L, (L+R)/2, 2*idx, node, val);
	}
}
