import java.io.*;
import java.util.*;

public class b_1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken()) - 1;
		int b = Integer.parseInt(st.nextToken()) - 1;
		int ans = 0;
		while(a != b) {
			a /= 2;
			b /= 2;
			ans++;
		}
		System.out.println(ans);
	}
}
