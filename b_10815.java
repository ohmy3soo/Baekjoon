import java.util.*;
import java.io.*;

public class b_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<Integer>();

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			hs.add(Integer.parseInt(st.nextToken()));


		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder(2*M);
		for(int i=0; i<M; i++) {
			if(hs.contains(Integer.parseInt(st.nextToken())))
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}

		System.out.println(sb);

	}
}
