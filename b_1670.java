import java.io.*;
import java.util.*;

public class b_1670 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] DP = new long[N+1];

		DP[0] = 1;
		DP[2] = 1;
		DP[4] = 2;

		for(int i=6; i<=N; i+=2) {
			for(int j=0; j<(i-2)/2; j+=2) {
				DP[i] += 2*(DP[i-2-j]*DP[j]);
				DP[i] %= 987654321;
			}
			if((i-2)%2 == 0)
				DP[i] += (DP[(i-2)/2] * DP[(i-2)/2]) % 987654321;
		}

		System.out.println(DP[N] % 987654321);
	}
}
