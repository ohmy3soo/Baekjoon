import java.io.*;
import java.util.*;

public class b_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String p = in.readLine();
		String m = "";
		int idx = p.indexOf('-');
		if(idx > -1) {
			m = p.substring(idx);
			p = p.substring(0, idx);
		}

		int ans = 0;
		int num = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '+') {
				ans += num;
				num = 0;
			}
			else {
				num  = num*10 + (p.charAt(i)-'0');
			}
		}
		ans += num;

		num = 0;
		for(int i=0; i<m.length(); i++) {
			if(m.charAt(i) == '+' || m.charAt(i) == '-') {
				ans -= num;
				num = 0;
			}
			else {
				num  = num*10 + (m.charAt(i)-'0');
			}
		}
		ans -= num;

		System.out.println(ans);
	}
}
