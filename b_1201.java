import java.io.*;
import java.util.*;

public class b_1201 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(M*K < N || M+K-1 > N) {
			System.out.println(-1);
			return;
		}

		arr.add(0);
		arr.add(K);
		for(int i=1; i<=M-1; i++)
			arr.add(K+i*(N-K)/(M-1));

		for(int i=1; i<arr.size(); i++) {
			int stop = arr.get(i);
			while(stop > arr.get(i-1)) {
				sb.append(stop +" ");
				stop--;
			}
		}

		System.out.println(sb);

	}
}
