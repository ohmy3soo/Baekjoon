import java.io.*;
import java.util.*;

public class b_1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(in.readLine());

		int length = 64;
		int s = length;
		int ans = 1;
		while(length != X) {
			s /= 2;
			if(length-s >= X) {
				length -= s;
				ans--;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
