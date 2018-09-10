import java.io.*;

public class b_1701 {
	
	static int[] pi;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s= in.readLine();

		for(int i=0; i<s.length(); i++)
			setPi(s.substring(i));
		
		System.out.println(ans);
	}
	
	static void setPi(String input) {
		pi = new int[input.length()];
		int begin=1, match=0;
		while(begin+match < input.length()) {
			if(input.charAt(begin+match) == input.charAt(match)) {
				match++;
				pi[begin+match-1] = match;
				ans = Math.max(ans, pi[begin+match-1]);
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
