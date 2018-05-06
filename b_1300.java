import java.util.*;
import java.io.*;

public class b_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());

		long s=1, e=(long)N*N, mid=0;
		long result = 0;
		System.out.println(e);
		while(s<=e) {
			mid = (s+e)/2;
			long count = 0;
			for(int i=1; i<=N; i++)
				count += Math.min(N, mid/i);
			if(count>=k) {
				result = mid;
				e = mid-1;
			}
			else
				s = mid+1;
		}
		System.out.println(result);
	}
}
