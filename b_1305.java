import java.io.*;
import java.util.*;

public class b_1305 {
	
	static int L;
	static String input;
	static int[] pi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(in.readLine());
		input = in.readLine();
		setPi();
		System.out.println(L-pi[L-1]);
	}
	
	static void setPi() {
		pi = new int[L];
		int begin=1, match=0;
		while(begin+match < L) {
			if(input.charAt(begin+match) == input.charAt(match)) {
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
