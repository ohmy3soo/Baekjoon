package NA6_1;
import java.io.*;
import java.util.*;

public class b_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(arr);
		
		int L = 1;
		int R = (arr[arr.length-1] - arr[0]) / (C-1);
		int ans = (L+R)/2;
		
		while(L<=R) {
			int remain = C-1;
			int pos = arr[0];
			int d = (L+R)/2;
			
			for(int i=1; i<N; i++) {
				if(arr[i] - pos >= d) {
					pos = arr[i];
					remain--;
				}
			}
			
			if(remain <= 0) {
				ans = d;
				L = d+1;
			}
			else
				R = d-1;
		}
		System.out.println(ans);
	}
}
