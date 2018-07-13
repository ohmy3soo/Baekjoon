import java.io.*;
import java.util.*;

public class b_2490 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] result = { 'E', 'A', 'B', 'C', 'D' };
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int count = 0;
			while(st.hasMoreTokens())
				if(st.nextToken().charAt(0) == '0') count++;
			
			sb.append(result[count]+"\n");
		}
		System.out.println(sb);
	}
}
