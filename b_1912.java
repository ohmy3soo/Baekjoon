import java.io.*;
import java.util.*;

public class b_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		int[] input = new int[n];
		int[] DP = new int[n];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			input[i] = Integer.parseInt(st.nextToken());

		DP[0] = input[0];
		int ans = input[0];

		// 간략히 해보기
		for(int i=1; i<n; i++) {
			if(DP[i-1] < 0)
				DP[i] = input[i];
			else {
				if(DP[i-1] + input[i] < 0)
					DP[i] = 0;
				else
					DP[i] = DP[i-1] + input[i];
 			}
			ans = Math.max(ans, DP[i]);
		}

		System.out.println(ans);
	}
}
