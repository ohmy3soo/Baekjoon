import java.io.*;
import java.util.*;

public class b_1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double d = Math.pow(Math.pow((x1-x2),2) + Math.pow((y1-y2), 2), 0.5);
			if( d > r1+r2 )
				sb.append(0 + "\n");
			else if( d == r1+r2 )
				sb.append(1 + "\n");
			else if( d < r1+r2) {
				if( d == 0 ) {
					if( r1 == r2 )
						sb.append(-1 + "\n");
					else sb.append(0 + "\n");
				}
				else {
					double id = Math.max(r1, r2) - (d+Math.min(r1, r2));
					if( id > 0)
						sb.append(0 + "\n");
					else if( id == 0)
						sb.append(1 + "\n");
					else
						sb.append(2 + "\n");
				}
			}	
		}
		System.out.println(sb);
	}
}
