import java.io.*;
import java.util.*;

public class b_1783 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int ans = 0;
		if(N == 1)
			ans = 1;
		else if(N == 2) {
			ans = Math.min(4, (M+1)/2);
		}
		else {
			if(M<7)
				ans = Math.min(4, M);
			else
				ans = M-2;
		}
		System.out.println(ans);
	}
}
