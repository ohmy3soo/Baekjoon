import java.io.*;
import java.util.*;

public class b_2104 {

	static long[] sum_tree;
	static int[] min_tree, arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N+1];
		int h = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		sum_tree = new long[1<<h];
		min_tree = new int[1<<h];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		s_init(1, N, 1);
		m_init(1, N, 1);

		long ans = solve(1,N);
		System.out.println(ans);

	}
	static long solve(int L, int R) {
		if(L==R)
			return arr[L]*(long)arr[L];


		int mid = (L+R)/2;
		int left = mid;
		int right = mid+1;
		long ret = Math.max(solve(L, mid), solve(mid+1, R));

		int tempMin = getMin(left, right, 1, N, 1);
		while(left > L || right < R) {
			while(right<R && arr[right+1] >= tempMin)
				right++;
			while(left>L && arr[left-1] >= tempMin)
				left--;

			ret = Math.max(ret, getSum(left, right, 1, N, 1)*tempMin);

			if(right < R && (left==L || arr[left-1] <= arr[right+1])) {
				right++;
				tempMin = arr[right];
			}
			else if(left > L) {
				left--;
				tempMin = arr[left];
			}
			ret = Math.max(ret, getSum(left, right, 1, N, 1)*tempMin);
		}
		return ret;
	}




	static long s_init(int L, int R, int idx) {
		if(L==R) return sum_tree[idx] = arr[L];
		else return sum_tree[idx] = s_init(L, (L+R)/2, 2*idx) + s_init((L+R)/2+1, R, 2*idx+1);
	}
	static long getSum(int sL, int sR, int L, int R, int idx) {
		if(sL > R || sR < L) return 0;
		if(sL <= L && sR >= R) return sum_tree[idx];
		else return getSum(sL, sR, L, (L+R)/2, 2*idx) + getSum(sL, sR, (L+R)/2+1, R, 2*idx+1);
	}
	static int m_init(int L, int R, int idx) {
		if(L==R) return min_tree[idx] = arr[L];
		else return min_tree[idx] = Math.min(m_init(L, (L+R)/2, 2*idx), m_init((L+R)/2+1, R, 2*idx+1));
	}
	static int getMin(int sL, int sR, int L, int R, int idx) {
		if(sL > R || sR < L) return Integer.MAX_VALUE;
		if(sL <= L && sR >= R) return min_tree[idx];
		else return Math.min(getMin(sL, sR, L, (L+R)/2, 2*idx), getMin(sL, sR, (L+R)/2+1, R, 2*idx+1));
	}
}
