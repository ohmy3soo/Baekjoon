import java.io.*;
import java.util.*;

public class b_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());

		for(int i=0; i<T; i++) {
			int M, N, x, y;
			String input = in.readLine();
			StringTokenizer st = new StringTokenizer(input);
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int last = getLCM(M,N);
			int year = x;

			while( year <= last) {
				if(year % N == y)
					break;
				if(N == y && year % N == 0)
					break;
				year += M;
			}
			if(year > last)
				//out.write("-1\n");
				//out.append(-1 + "\n");
				System.out.println(-1);
			else
				//out.write(year+"\n");
				//out.append(year + "\n");
				System.out.println(year);

		}
		//in.close();
		//out.flush();
		//out.close();

	}
	static int getLCM(int x, int y) {
		int d = Math.abs(x-y);

		if( x%y == 0 || y%x == 0 )
			return Math.max(x, y);
		if( x%d == 0 && y%d == 0)
			return x*y/d;
		else
			return x*y;
	}
}
