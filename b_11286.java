import java.io.*;
import java.util.*;

public class b_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		for(int i=0; i<N; i++) {
			int val = Integer.parseInt(in.readLine());
			if(val == 0) {
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}
			else pq.add(val);
		}
		System.out.println(sb);
	}
}
