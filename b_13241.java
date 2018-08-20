import java.io.*;
import java.util.*;

public class b_13241 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long max = Math.max(A, B);
		long min = Math.min(A, B);
		while(max%min != 0) {
			long temp = min;
			min = max%min;
			max = temp;
		}
		System.out.println(A*B/min);
	}
}
