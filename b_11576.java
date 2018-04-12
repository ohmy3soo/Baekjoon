import java.util.*;
import java.io.*;

public class b_11576 {

	static int A, B, m;
	static Stack<Integer> result = new Stack<>();
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());

		int decimal = 0;
		for(int i=0; i<m; i++)
			decimal += Integer.parseInt(st.nextToken()) * Math.pow(A, m-i-1);

		while(decimal > 0) {
			result.push(decimal%B);
			decimal /= B;
		}

		while(!result.isEmpty())
			out.append(result.pop() + " ");

		out.flush();
		in.close();
		out.close();

	}
}
