import java.io.*;
import java.util.*;

public class b_9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] isPrime = new boolean[10001];
		for(int i=0; i<10001; i++)
			isPrime[i] = true;

		for(int i=2; i<10001; i++) {
			int idx = 2;
			while(i*idx < 10001) {
				isPrime[i*idx] = false;
				idx++;
			}
		}
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(in.readLine());
			OUTER:
			for(int i=n/2; i>=2; i--) {
				if(isPrime[i] == true) {
					for(int j=n/2; j<10001; j++) {
						if(isPrime[j] == true) {
							if(i+j==n) {
								sb.append(i + " " + j + "\n");
								break OUTER;
							}
							if(i+j>n)
								break;
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
