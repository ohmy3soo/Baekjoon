import java.io.*;
import java.util.*;

public class b_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] DP = new int[k+1];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(in.readLine());

		DP[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j >= arr[i])
					DP[j] += DP[j-arr[i]];
			}
		}

		System.out.println(DP[k]);



	}
}
