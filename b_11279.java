import java.util.*;
import java.io.*;

public class b_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(in.readLine());
			if(input == 0) {
				int v = q.size()>0 ? q.poll() : 0;
				sb.append(v + "\n");
			}
			else
				q.add(input);
		}
		System.out.println(sb);

	}
}
