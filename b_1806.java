package TwoPointers;
import java.io.*;
import java.util.*;

public class b_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int s=0, e=0;
		int len = Integer.MAX_VALUE;
		int sum = 0;
		boolean find = false;
		while(true) {
			if(sum <= S && e<N) sum += arr[e++];
			else if(s==N) break;
			else sum -= arr[s++];
			
			if(sum >= S) {
				find = true;
				len = Integer.min(len, e-s);
			}
		}
		if(find) System.out.println(len);
		else System.out.println(0);
	}
}
