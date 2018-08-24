package p25;
import java.io.*;
import java.util.*;

public class b_2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(arr);
		
		int s=0, e=0;
		int ans = Integer.MAX_VALUE;
		while(true) {
			if(e == N) break;
			if(M==0) ans = Math.min(ans, arr[e++] - arr[s++]);
			else if(arr[e] - arr[s] < M) e++;
			else ans = Math.min(ans, arr[e] - arr[s++]);
		}
		
		System.out.println(ans);
	}
}
