package p23;
import java.io.*;
import java.util.*;

public class b_2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] s = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			s[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(s);
		int idx1=0, idx2=1, idx3=2;
		long ans = 3 * (long)1_000_000_000;
		for(int i=0; i<=N-3; i++) {
			int L = i+1;
			int R = N-1;
			while(L < R) {
				if(ans > Math.abs((long)s[i]+s[L]+s[R])) {
					idx1 = i;
					idx2 = L;
					idx3 = R;
					ans = Math.abs((long)s[i]+s[L]+s[R]);
				}
				if(Math.abs((long)s[i] + s[L+1] + s[R]) < Math.abs((long)s[i] + s[L] + s[R-1])) L++;
				else R--;
			}
		}
		System.out.println(s[idx1] + " " + s[idx2] + " " + s[idx3]);
	}
}
