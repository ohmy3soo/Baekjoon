import java.io.*;

public class b_10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = in.readLine();
		int[] alp = new int[26];
		for(int i=0; i<input.length(); i++)
			alp[input.charAt(i) - 'a']++;
		
		for(int i=0; i<26; i++)
			sb.append(alp[i] + " ");
		System.out.println(sb);
	}
}
