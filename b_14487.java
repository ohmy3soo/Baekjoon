import java.io.*;
import java.util.*;

public class b_14487 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int max = 0;
		int total = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int cost = Integer.parseInt(st.nextToken());
			total += cost;
			max = Math.max(max, cost);
		}
		
		System.out.println(total-max);
	}
}
