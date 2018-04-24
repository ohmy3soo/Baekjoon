import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class b_10826 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		BigInteger f1 = BigInteger.ZERO;
		if(n==0) {
			System.out.println(f1.toString());
			return;
		}
		BigInteger f2 = BigInteger.ONE;
		if(n==1) {
			System.out.println(f2);
			return;
		}

		BigInteger temp;
		for(int i=0; i<n-1; i++) {
			temp = f2;
			f2 = f1.add(f2);
			f1 = temp;
		}

		System.out.println(f2);
	}
}
