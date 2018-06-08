import java.io.*;
import java.util.*;

public class b_2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(in.readLine());
		int N = Integer.parseInt(in.readLine());

		boolean[] prime = new boolean[N+1];
		for(int i=2; i<N+1; i++)
			prime[i] = true;

		for(int i=2; i<=N; i++) {
			for(int j=2; j<=N; j++) {
				if(j%i == 0 && j!=i)
					prime[j] = false;
			}
		}
		int ans1 = 0;
		int ans2 = 0;
		for(int i=M; i<=N; i++) {
			if(prime[i] == true) {
				ans2 = (ans2 == 0)? i : ans2;
				ans1 += i;
			}
		}
		if(ans1 == 0)
			sb.append(-1);
		else
			sb.append(ans1+"\n"+ans2);
		System.out.println(sb);
	}
}
