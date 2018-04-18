import java.io.*;
import java.util.*;

public class b_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> hs = new HashSet<>(); 
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			hs.add(Integer.parseInt(st.nextToken()));
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			if(hs.contains(Integer.parseInt(st.nextToken())))
				sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		
		System.out.println(sb);
	}
}
