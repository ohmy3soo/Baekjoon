import java.io.*;
import java.util.*;

public class b_10824 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String AB = st.nextToken() + st.nextToken();
		String CD = st.nextToken() + st.nextToken();
		
		System.out.println(Long.parseLong(AB) + Long.parseLong(CD));
		
		// A, B, C, D < 1,000,000 ( 7자리 )
		// int == -2147483648 ~ 2147483647
		// --> Long
	}
}
