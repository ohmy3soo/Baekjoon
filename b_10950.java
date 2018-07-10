import java.io.*;
import java.util.*;

public class b_10950 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
		}
		System.out.println(sb);
	}
}
