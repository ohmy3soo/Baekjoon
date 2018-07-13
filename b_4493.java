import java.io.*;
import java.util.*;

public class b_4493 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("RS", 0);
		hm.put("RP", 1);
		hm.put("SP", 0);
		hm.put("SR", 1);
		hm.put("PR", 0);
		hm.put("PS", 1);
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] score = new int[2];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();
				if(p1.equals(p2)) continue;
				score[hm.get(p1+p2)]++;
			}
			if(score[0] > score[1]) sb.append("Player 1\n");
			else if(score[0] < score[1]) sb.append("Player 2\n");
			else sb.append("TIE\n");
		}
		System.out.println(sb);
	}
}
