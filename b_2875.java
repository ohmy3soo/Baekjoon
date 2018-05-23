import java.io.*;
import java.util.*;

public class b_2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 0;
		while(N+M >= K+3 && N>=2 && M>=1) {
			N -= 2;
			M -= 1;
			ans += 1;
		}
		System.out.println(ans);
	}
}
