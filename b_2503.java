package p24_2;
import java.io.*;
import java.util.*;

public class b_2503 {
	static boolean[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		num = new boolean[1000];
		Arrays.fill(num, true);
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int q = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			update(q, s ,b);
		}
		
		System.out.println(countNum());
		
	}
	static void update(int input, int s, int b) {
		
		int n3 = input%10;
		input /= 10;
		int n2 = input%10;
		input /= 10;
		int n1 = input%10;
		
		for(int k=123; k<=987; k++) {
			int ts =0;
			int tb =0;
			if(k/100 == n1) ts++;
			else if(k%10 == n1 || k/10%10 == n1) tb++;
			
			if(k/10%10 == n2) ts++;
			else if(k/100 == n2 || k%10 == n2) tb++;
			
			if(k%10 == n3) ts++;
			else if(k/10%10 == n3 || k/100 == n3) tb++;
			
			if(ts != s || tb != b) num[k] = false;
		}
	}
	
	static int countNum() {
		int ret = 0;
		for(int k=123; k<=987; k++)
			if(num[k] && 
					(k%10 != k/10%10 && k/10%10 != k/100 && k%10 != k/100) &&
					(k%10 != 0 && k/10%10 != 0 && k/100 != 0)) ret++;
		return ret;
	}
}
