import java.io.*;
import java.util.*;

public class b_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());
		Stack<Integer> S = new Stack<>();

		int idx = 1;
		for(int i=1; i<=n; i++) {
			int input = Integer.parseInt(in.readLine());
			for(int j=idx; j<=input; j++) {
				S.push(j);
				sb.append('+'+"\n");
			}
			if(input != S.pop()) {
				sb = new StringBuilder("NO");
				break;
			}
			sb.append('-'+"\n");
			if(input >= idx)
				idx = input+1;
		}
		System.out.println(sb);
	}
}
