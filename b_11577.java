import java.io.*;
import java.util.*;

public class b_11577 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] mask = new int[K];
		for(int i=0; i<K; i++)
			mask[i] = 1;

		st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int s=0, e=N-1;
		int count = 0;
		OUTER:
		while(s<=e) {
			while(arr[s] == 0) {
				if(s+K > e)
					break OUTER;
				s++;
			}
			for(int i=0; i<K; i++)
				arr[s+i] ^= mask[i];
			count++;
			s++;

			while(arr[e] == 0) {
				if(s+K > e)
					break OUTER;
				e--;
			}
			for(int i=0; i<K; i++)
				arr[e-K+i+1] ^= mask[i];
			count++;
			e--;
		}

		for(int i=0; i<N; i++) {
			if(arr[i] != 0) {
				System.out.println("Insomnia");
				return;
			}
		}
		System.out.println(count);

	}
}
