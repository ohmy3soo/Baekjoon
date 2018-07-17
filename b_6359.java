package NA6_1;
import java.io.*;
import java.util.*;

public class b_6359 {
	static int[] open = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=100; i++)
			open[i] = (int)Math.sqrt(i);
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++)
			sb.append(open[Integer.parseInt(in.readLine())] + "\n");
		
		System.out.println(sb);
	}
}
