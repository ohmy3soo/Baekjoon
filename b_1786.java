import java.io.*;

public class b_1786 {
	static String T, P;
	static int[] pi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = in.readLine();
		P = in.readLine();
		
		setPi();

		int ans = 0;
		int begin=0, match=0;
		while(begin <= T.length() - P.length()) {
			if(match < P.length() && T.charAt(begin+match) == P.charAt(match)) {
				match++;
				if(match == P.length()) {
					ans++;
					sb.append(begin+1 + " ");
				}
			}
			else {
				if(match == 0) begin++;
				else {
					begin += match - pi[match-1];
					match = pi[match-1];
				}
			}
		}
		System.out.println(ans);
		System.out.println(sb);
	}
	static void setPi() {
		pi = new int[P.length()];
		int begin=1, match=0;
		while(begin+match < P.length()) {
			if(P.charAt(begin+match) == P.charAt(match)) {
				match++;
				pi[begin+match-1] = match;
			}
			else {
				if(match == 0) begin++;
				else {
					begin += match - pi[match-1];
					match = pi[match-1];
				}
			}
		}
	}
}
