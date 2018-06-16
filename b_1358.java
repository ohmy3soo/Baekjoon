package NA2_2;
import java.io.*;
import java.util.*;

public class b_1358 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x < X - H/2 || x > X + W + H/2 || y < Y || y > Y + H)
				continue;
			if(x >= X && x <= X+W)
				ans++;
			else {
				int p = (x>X)? X+W : X;
				if(getDistance(x,y,p,Y+H/2) <= H/2)
					ans++;
			}
		}
		System.out.println(ans);
	}
	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
