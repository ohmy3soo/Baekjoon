import java.io.*;
import java.util.*;

public class b_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] s = new String[2];

		for(int i=0; i<2; i++)
			s[i] = in.readLine();
		int[][] DP = new int[s[0].length()+1][s[1].length()+1];


		for(int i=1; i<=s[0].length(); i++) {
			for(int j=1; j<=s[1].length(); j++) {
				if(s[0].charAt(i-1) == s[1].charAt(j-1))
					DP[i][j] = DP[i-1][j-1] + 1;
				else
					DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
			}
		}

		System.out.println(DP[s[0].length()][s[1].length()]);

	}
}
