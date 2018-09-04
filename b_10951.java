import java.io.*;
import java.util.*;

public class b_10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = "";
		while((input = in.readLine()) != null) {
			if(input.equals("")) break;
			StringTokenizer st = new StringTokenizer(input);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append((A+B) + "\n");
		}
		System.out.println(sb);
	}
}
