package p23;
import java.io.*;
import java.util.*;

public class b_14919 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(in.readLine());
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			String input = st.nextToken() + "000000";
			input = input.substring(2, 8);
			int A = m * Integer.parseInt(input);
			arr[(int)(A/1_000_000)]++;
		}
		
		for(int a : arr)
			sb.append(a + " ");
		System.out.println(sb);
		
	}
}
