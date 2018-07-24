import java.io.*;
import java.util.*;

public class b_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++)
			pq.add(Integer.parseInt(in.readLine()));
		
		int ans = 0;
		while(pq.size() > 1) {
			int update = pq.poll() + pq.poll();
			ans += update;
			pq.add(update);
		}
		
		System.out.println(ans);
	}
}
