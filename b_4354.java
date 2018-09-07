import java.io.*;
import java.util.*;

public class b_4354 {
	
	static int[] pi;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = in.readLine();
			if(input.equals(".")) break;
			
			setPi(input);
			if(input.length() % (input.length() - pi[input.length()-1]) != 0)
				sb.append("1\n");
			else sb.append(input.length() / (input.length() - pi[input.length()-1]) + "\n");
		}
		System.out.println(sb);
	}
	static void setPi(String s) {
		pi = new int[s.length()];
		int begin=1, match=0;
		while(begin+match < s.length()) {
			if(s.charAt(begin+match) == s.charAt(match)) {
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
