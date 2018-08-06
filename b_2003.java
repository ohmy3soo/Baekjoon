package TwoPointers;
import java.io.*;
import java.util.*;

public class b_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int s = 0, e = 0;
		int sum = 0;
		int ans = 0;
		while(true) {
			if(sum >= M) sum -= arr[s++];
			else if(e == N) break;
			else sum += arr[e++];
			
			if(sum == M) ans++;
		}
		
		System.out.println(ans);
		
	}
}
