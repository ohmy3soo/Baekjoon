package TwoPointers;
import java.io.*;
import java.util.*;

public class b_1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(prime[i] == true) {
				for(int j=i*i; j<=N; j+=i)
					prime[j] = false;
			}
		}
		for(int i=1; i<=N; i++)
			if(prime[i]) arr.add(i);
		
		int s=0, e=0;
		int sum=0, ans=0;
		while(true) {
			if(sum >= N) sum -= arr.get(s++);
			else if(e == arr.size()) break;
			else sum += arr.get(e++);
			
			if(sum == N) ans++;
		}
		System.out.println(ans);
		
	}
}
