package p19;
import java.io.*;
import java.util.*;

public class b_14002 {
	static int[] arr;
	static int[] DP;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		DP = new int[N];
		
		int ans = 0;
		for(int i=0; i<arr.length; i++)
			ans = Math.max(ans, search(i));
		System.out.println(ans);
		print(0, ans);
	}
	static int search(int start) {
		if(DP[start] !=0 ) return DP[start];
		
		int ret = 1;
		for(int i=start+1; i<arr.length; i++)
			if(arr[i] > arr[start]) ret = Math.max(ret, search(i)+1);
		return DP[start] = ret;
	}
	
	static void print(int start, int val) {
		for(int i=start; i<arr.length; i++) {
			if(DP[i] == val) {
				sb.append(arr[i]);
				if(val != 1)
					sb.append(" ");
				else
					System.out.println(sb);
				print(i, val-1);
				break;
			}
		}
	}
}
