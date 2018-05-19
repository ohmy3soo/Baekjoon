import java.io.*;
import java.util.*;

public class b_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			P[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(P);

		int ans = P[0];
		for(int i=1; i<N; i++) {
			P[i] += P[i-1];
			ans += P[i];
		}

		System.out.println(ans);

	}
}
