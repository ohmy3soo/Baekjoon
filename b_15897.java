import java.io.*;
import java.util.*;

public class b_15897 {
	static int n, v;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		long ans = n;
		v = n-1;
		int pre = 1;
		int idx = 1;
		while(v != 0) {
			idx = solve(idx, n);
			ans += (idx-pre)*v;
			pre = idx;
			v = (n-1)/idx;
		}
		System.out.println(ans);
	}
	
	static int solve(int L, int R) {
		
		while(L+1 < R) {
			int mid = (L+R)/2;
			if((n-1)/mid == v) L = mid;
			else R = mid;
		}
		
		return R;
	}
}
