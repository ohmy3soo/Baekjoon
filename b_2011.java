import java.io.*;
import java.util.*;

public class b_2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		int[] DP = new int[input.length()+1];

		DP[input.length()] = 1;
		DP[input.length()-1] = (input.charAt(input.length()-1) == '0')? 0 : 1;

		for(int i=input.length()-2; i>=0; i--) {
			String check = input.substring(i, i+2);
			if(check.charAt(0) == '0')
				DP[i] = 0;
			else if(Integer.parseInt(check) <= 26){
				DP[i] = DP[i+1] + DP[i+2];
			}
			else
				DP[i] = DP[i+1];
			DP[i] %= 1000000;
		}

		System.out.println(DP[0]);

	}
}
