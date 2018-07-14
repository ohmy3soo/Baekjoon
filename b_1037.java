import java.io.*;
import java.util.*;

public class b_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long ans= 0;
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			max = Math.max(max, next);
			min = Math.min(min, next);
		}
		ans = (long)max * min;
		System.out.println(ans);
	}
}
