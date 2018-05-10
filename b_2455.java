import java.io.*;
import java.util.*;

public class b_2455 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;
		StringTokenizer st;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(in.readLine());
			ans = Math.max(ans, ans - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
		System.out.println(ans);
	}
}
