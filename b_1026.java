import java.io.*;
import java.util.*;

public class b_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Integer[] A = new Integer[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Integer[] B = new Integer[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int ans = 0;
		for(int i=0; i<N; i++)
			ans += A[i]*B[i];
		System.out.println(ans);
		
	}
}
