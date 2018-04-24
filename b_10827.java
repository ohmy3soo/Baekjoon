`import java.util.*;
import java.io.*;
import java.math.*;

public class b_10827 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		BigDecimal a = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// without an exponent field
		System.out.println(a.pow(b).toPlainString());
	}
}
