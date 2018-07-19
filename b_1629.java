import java.io.*;
import java.util.*;

public class b_1629 {
	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long ans = solve(B);
		System.out.println(ans);
	}
	
	static long solve(long n) {
		if(n==1) return A%C;
		long temp = solve(n/2)%C;
		if(n%2 == 1) return (((temp*temp)%C) * (A%C))%C;
		else return (temp*temp)%C;
	}
}
