import java.io.*;
import java.util.*;

public class b_11055 {

	static int[] arr;
	static int[] DP;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		DP = new int[N];
		Arrays.fill(DP, -1);

		int ans = 0;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, arr[i] + search(i));
		System.out.println(ans);

	}
	static int search(int start) {
		if(DP[start] != -1) return DP[start];

		int ret = 0;
		for(int i=start+1; i<N; i++) {
			if(arr[start] < arr[i])
				ret = Math.max(ret, arr[i] + search(i));
		}
		return DP[start] = ret;
	}
}
