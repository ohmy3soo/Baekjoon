import java.io.*;
import java.util.*;

public class b_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int[] wines = new int[n+2];
		int[] DP = new int[n+2];
		for(int i=1; i<=n; i++)
			wines[i] = Integer.parseInt(in.readLine());

		DP[1] = wines[1];
		DP[2] = wines[1] + wines[2];

		for(int i=3; i<=n; i++)
			DP[i] = Math.max(Math.max(DP[i-2] + wines[i], DP[i-3]+wines[i-1]+wines[i]), DP[i-1]);


		System.out.println(DP[n]);

	}
}
