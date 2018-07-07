import java.io.*;
import java.util.*;

public class b_11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Stack<Integer> sell = new Stack<>();
			sell.push(N-1);
			for(int i=N-2; i>=0; i--)
				if(arr[i] > arr[sell.peek()]) sell.push(i);
			
			long ans = 0;
			for(int i=0; i<N; i++) {
				if(i<sell.peek())
					ans += arr[sell.peek()]-arr[i];
				else
					sell.pop();
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
