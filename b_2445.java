import java.io.*;

public class b_2445 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		for(int i=1; i<=2*N-1; i++) {
			int idx = (i>N)? 2*N-i : i;
			int c = idx;
			int b = 2*N - 2*idx;
			for(int t=0; t<c; t++) sb.append('*');
			for(int t=0; t<b; t++) sb.append(' ');
			for(int t=0; t<c; t++) sb.append('*');
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
