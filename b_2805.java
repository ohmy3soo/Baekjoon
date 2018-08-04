import java.io.*;
import java.util.*;

public class b_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());	// 나무의 수
		int M = Integer.parseInt(st.nextToken());	// 나무의 길이

		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int L = 0;
		int R = max;

		long sum = 0;
		while(L+1 < R) {
			sum = 0;
			int mid = (L+R)/2;
			for(int i=0; i<N; i++)
				if(arr[i]-mid > 0) sum += arr[i]-mid;

			if(sum >= M) L = mid;
			else R = mid;
		}

		System.out.println(L);

	}
}
