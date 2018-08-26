import java.io.*;

public class b_2447 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(in.readLine());

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a = i;
				int b = j;
				while(a!=0 || b!=0) {
					if(a%3 == 1 && b%3 == 1) {
						sb.append(" ");
						break;
					}
					else {
						a /= 3;
						b /= 3;
					};
				}
				if(a == 0 && b == 0)
					sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
