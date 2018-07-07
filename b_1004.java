import java.io.*;
import java.util.*;

public class b_1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] start = new int[2];
			int[] end = new int[2];
			for(int i=0; i<2; i++)
				start[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<2; i++)
				end[i] = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(in.readLine());
			
			int c1 = 0;
			int c2 = 0;
			int c3 = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int d1 = getDistance(start[0], start[1], x, y);
				int d2 = getDistance(end[0], end[1], x, y);
				if(d1 < r*r) c1++;
				if(d2 < r*r) c2++;
				if(d1 < r*r && d2 < r*r) c3++;
			}
			sb.append(c1+c2-2*c3+"\n");
		}
		System.out.println(sb);
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
}
