import java.util.*;
import java.io.*;

public class b_11575 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int i=0; i<T; i++) {
			String ab = in.readLine();
			StringTokenizer st = new StringTokenizer(ab);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			String input = in.readLine();
			for(int j=0; j<input.length(); j++) {
				char x = input.charAt(j);
				int y = (a*(x-'A')+b) % 26;
				
				out.append((char)(y+'A'));
			}
			out.append('\n');
		}
		
		out.flush();
		out.close();
	}
}
