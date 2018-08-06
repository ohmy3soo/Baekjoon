package TwoPointers;
import java.io.*;
import java.util.*;

public class b_1484 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int G = Integer.parseInt(in.readLine());
		
		boolean find = false;
		int pre=1, cur=1;
		while(true) {
			int diff = cur*cur - pre*pre;
			if(cur-pre == 1 && diff > G) break;
			else if(diff>=G) pre++;
			else cur++;
			
			if(diff == G) {
				find = true;
				sb.append(cur+"\n");
			}
		}
		if(find) System.out.println(sb);
		else System.out.println(-1);
	}
}
