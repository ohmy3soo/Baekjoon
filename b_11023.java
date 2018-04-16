import java.io.*;
import java.util.*;

public class b_11023 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int sum = 0;
		while(st.hasMoreTokens())
			sum += Integer.parseInt(st.nextToken());

		System.out.println(sum);
	}
}
