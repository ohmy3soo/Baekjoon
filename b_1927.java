import java.util.*;
import java.io.*;

public class b_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
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
