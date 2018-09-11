import java.io.*;
import java.util.*;

public class b_1965 {
	static int[] DP, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		arr = new int[N];
		DP = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		DP[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			if(DP[idx] < arr[i]) DP[++idx] = arr[i];
			else {
				int update = getIndex(-1, idx, arr[i]);
				DP[update] = arr[i];
			}
		}
		
		System.out.println(idx+1);
	}
	static int getIndex(int L, int R, int value) {
		while(L+1 < R) {
			int mid = (L+R)/2;
			if(DP[mid] < value) L = mid;
			else R = mid;
		}
		return R;
	}
}
