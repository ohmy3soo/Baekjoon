import java.io.*;
import java.util.*;

public class b_4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n==0)
				break;
			ArrayList<Integer> arr = new ArrayList<>();
			int ans = 0;
			boolean[] isPrime = new boolean[2*n+1];
			for(int i=0; i<=2*n; i++)
				isPrime[i] = true;

			for(int i=2; i<=2*n; i++) {
				int idx = 2;
				if(isPrime[i] == true && i>n)
					ans++;
				while(i*idx <= 2*n) {
					isPrime[i*idx] = false;
					idx++;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
