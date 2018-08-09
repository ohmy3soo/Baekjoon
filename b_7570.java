package p23;
import java.io.*;
import java.util.*;

public class b_7570 {
	static int N;
	static int[] arr, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[N+1];
		sum = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int s = Integer.parseInt(st.nextToken());
			arr[i] = s;
			sum[s] = sum[s-1]+1;
		}
		
		int max = 0;
		for(int i=1; i<=N; i++)
			max = Math.max(max, sum[i]);
		
		System.out.println(N-max);
	}
}
