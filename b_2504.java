import java.io.*;
import java.util.*;

public class b_2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> S = new Stack<>();
		String input = in.readLine();
		for(int i=0; i<input.length(); i++) {
			String c = input.substring(i, i+1);
			if(c.equals("(") || c.equals("[")) {
				S.push(c);
			}
			else {
				int temp = 1;
				String pre="";
				while(!S.isEmpty()) {
					pre = S.pop();
					if(!pre.equals("(") && !pre.equals("[")) {
						temp = (temp==1)? 0: temp;
						temp += Integer.parseInt(pre);
					}
					if(pre.equals("[") && c.equals("]")) {
						S.push(String.valueOf(temp*3));
						break;
					}
					if(pre.equals("(") && c.equals(")")) {
						S.push(String.valueOf(temp*2));
						break;
					}
				}
				if(S.isEmpty()) {
					System.out.println(0);
					return;
				}
			}
		}

		int ans = 0;
		while(!S.empty()) {
			if(S.peek().equals("(") || S.peek().equals("[") || S.peek().equals(")") || S.peek().equals("]")) {
				System.out.println(0);
				return;
			}
			ans += Integer.parseInt(S.pop());
		}

		System.out.println(ans);
	}
}
