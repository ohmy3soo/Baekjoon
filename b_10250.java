import java.util.*;
import java.io.*;

public class b_10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for(int i=0; i<T; i++) {
			String input = in.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int H, W, N;
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			int Y = N % H == 0 ? H : N%H;
			int X = (int)Math.ceil(N / (float)H);

			String YY = ""+Y;
			String XX = X>=10 ? ""+X : "0"+X;


			System.out.println(YY+XX);
		}
	}
}
