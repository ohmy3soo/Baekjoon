import java.io.*;
import java.math.*;
import java.util.*;

public class b_2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		m = Math.min(m, n-m);
		
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for(int i=0; i<m; i++)
			a = a.multiply(BigInteger.valueOf(n-i));
		for(int i=1; i<=m; i++)
			b = b.multiply(BigInteger.valueOf(i));
		
		System.out.println(a.divide(b));
	}
}
