import java.io.*;
import java.util.*;

public class b_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Node_14501[] arr = new Node_14501[N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i] = new Node_14501(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] DP = new int[N+1];
		for(int i=1; i<=N; i++) {
			DP[i] = Math.max(DP[i-1], DP[i]);
			if(i + arr[i].t-1 <= N)
				DP[i+arr[i].t-1] = Math.max(DP[i+arr[i].t-1], DP[i-1] + arr[i].p);
		}
		System.out.println(DP[N]);	
	}
}

class Node_14501 {
	int t;
	int p;
	public Node_14501(int t, int p) {
		this.t = t;
		this.p = p;
	}
}