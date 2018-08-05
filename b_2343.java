import java.io.*;
import java.util.*;

public class b_2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		int sum = 0;
		int min = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			min = Math.max(min, arr[i]);
		}

		int L = min-1;
		int R = sum;

		while(L+1 < R) {
			int mid = (L+R)/2;
			int book = 1;
			int remain = mid;
			for(int i=0; i<N; i++) {
				if(remain - arr[i] >= 0)
					remain -= arr[i];
				else {
					book++;
					remain = mid - arr[i];
				}
			}
			if(book > M) L = mid;
			else R = mid;
		}

		System.out.println(R);

	}
}
