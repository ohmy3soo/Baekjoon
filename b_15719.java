import java.io.*;
import java.util.*;

public class b_15719 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N  = sc.nextInt();
		long sum = 0;
		long exp = (long)N*(N-1)/2;
		for(int i=0; i<N; i++)
			sum += sc.nextInt();

		System.out.println(sum-exp);
	}
}
