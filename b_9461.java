import java.io.*;
import java.util.*;

public class b_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		long[] DP = new long[101];

		DP[1] = DP[2] = DP[3] = 1;
		DP[4] = DP[5] = 2;
		for(int i=6; i<=100; i++)
			DP[i] = DP[i-1] + DP[i-5];
		for(int i=0; i<T; i++)
			sb.append(DP[Integer.parseInt(in.readLine())] + "\n");

		System.out.println(sb);
	}
}
