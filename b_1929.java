import java.io.*;
import java.util.*;

public class b_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());


		boolean[] prime = new boolean[N+1];
		for(int i=0; i<N+1; i++)
			prime[i] = true;

		for(int i=2; i<=N; i++) {
			int idx = 2;
			if(prime[i] == true && i>=M)
				arr.add(i);
			while(i*idx<=N) {
				prime[i*idx] = false;
				idx++;
			}
		}

		for(int i=0; i<arr.size(); i++)
			sb.append(arr.get(i)+"\n");
		System.out.println(sb);
	}
}
