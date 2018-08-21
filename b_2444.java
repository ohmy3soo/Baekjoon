import java.io.*;

public class b_2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int max = 2*N - 1;

		for(int i=1; i<=2*N-1; i++) {
			int idx = (i>N)? 2*N-i : i;
			int c = 2*idx - 1;
			int b = (max - c) / 2;
			for(int t=0; t<b; t++) sb.append(' ');
			for(int t=0; t<c; t++) sb.append('*');
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
