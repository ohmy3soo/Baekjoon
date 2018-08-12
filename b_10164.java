package p24_2;
import java.io.*;
import java.util.*;

public class b_10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K==0) {
			System.out.println(combination(N-1, M-1));
			return;
		}
		int a = (K-1)/M;
		int b = (K-1)%M;
		
		System.out.println(combination(a,b) * combination(N-1-a, M-1-b));
	}
	
	static long combination(int a, int b) {
		int n = (a+b);
		int c = Math.min(a, b);
		
		long top = 1;
		for(int i=0; i<c; i++)
			top *= (n-i);
		long bottom = 1;
		for(int i=0; i<c; i++)
			bottom *= (c-i);
		return top/bottom;
	}
}
