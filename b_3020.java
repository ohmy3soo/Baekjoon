package NA6_1;
import java.io.*;
import java.util.*;

public class b_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] D = new int[N/2];
		int[] U = new int[N/2];
		
		for(int i=0; i<N; i++) {
			if(i%2 == 0) D[i/2] = Integer.parseInt(in.readLine());
			else U[i/2] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(D);
		Arrays.sort(U);
		int count = 1;
		int ans = 2*N;
		
		for(int i=0; i<H; i++) {
			int temp = solve(D, i) + solve(U, H-i+1);
			
			if(ans == temp) count++;
			if(ans > temp) {
				ans = temp;
				count=1;
			}
		}
		System.out.println(ans + " " + count);
	}
	
	static int solve(int[] arr, int h) {
		int L = 0;
		int R = arr.length-1;
		int idx = 0;
		while(L<=R) {
			idx = (L+R)/2;
			if(arr[idx] < h)	 L = idx+1;
			else R = idx-1;
		}
		return arr.length - L;
	}
}
