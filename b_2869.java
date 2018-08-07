package NA11_1;
import java.io.*;
import java.util.*;

public class b_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		System.out.println((int)Math.ceil((V-A)/(double)(A-B)) + 1);
	}
}
