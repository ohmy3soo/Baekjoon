import java.io.*;

public class b_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] alp = new int[26];
		String input = in.readLine();
		for(int i=0; i<input.length(); i++)
			alp[input.charAt(i) - 'A']++;
		char[] ans = new char[input.length()];
		
		int odd = 0;
		for(int i=0; i<26; i++) {
			if(alp[i]%2 == 1) {
				odd++;
				if(odd==2) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				ans[input.length()/2] = (char)(i+'A');
				alp[i]--;
			}
			
		}
		
		int idx = 0;
		for(int i=0; i<26; i++) {
			if(idx == input.length()/2) break;
			while(alp[i] == 0)
				i++;
			while(alp[i] != 0) {
				ans[idx++] = (char)(i + 'A');
				ans[input.length()-idx] = (char)(i + 'A');
				alp[i] -= 2;
			}
		}
		
		for(int i=0; i<input.length(); i++)
			sb.append(ans[i]);
		System.out.println(sb);
	}
}
