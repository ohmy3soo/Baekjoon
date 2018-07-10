import java.io.*;

public class b_10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] Fib = new int[n+2];
		Fib[0] = 0;
		Fib[1] = 1;
		
		for(int i=2; i<=n; i++)
			Fib[i] = Fib[i-1] + Fib[i-2];
		
		System.out.println(Fib[n]);
	}
}
