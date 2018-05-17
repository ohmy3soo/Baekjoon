import java.io.*;
import java.util.*;

public class b_9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String s[] = new String[2];
		s[0] = in.readLine();
		s[1] = in.readLine();

		int[][] DP = new int[s[0].length()+1][s[1].length()+1];

		for(int i=1; i<=s[0].length(); i++) {
			for(int j=1; j<=s[1].length(); j++) {
				if(s[0].charAt(i-1) == s[1].charAt(j-1))
					DP[i][j] = DP[i-1][j-1]+1;
				else
					DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
			}
		}
		sb.append(DP[s[0].length()][s[1].length()]+"\n");
		int n = s[1].length();

		// while(dp[i][j] != 0)로 해보기!
		for(int m=s[0].length(); m>0; m--) {
			if(s[0].charAt(m-1) == s[1].charAt(n-1)) {
				stack.add(s[0].charAt(m-1));
				n--;
			}
			else {
				if(DP[m-1][n] < DP[m][n-1]) {
					n--;
					m++;
				}
			}
			if(n==0)
				break;
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb);

	}
}
