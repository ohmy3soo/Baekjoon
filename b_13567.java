import java.io.*;
import java.util.*;

public class b_13567 {
	static int M, n;
	static int[][] dir = { {1,0}, {0,1}, {-1,0}, {0,-1} };
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		

		int idx = 1;
		int[] pos = {0,0};
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String ins = st.nextToken();
			int val = Integer.parseInt(st.nextToken());
			
			if(ins.equals("TURN")) {
				if(val == 0) idx = (idx==0)? 3 : idx-1;
				else idx = (idx==3)? 0 : idx+1;
			}
			else {
				int next_y = pos[0]+val*dir[idx][0];
				int next_x = pos[1]+val*dir[idx][1];
				if(isValid(next_y, next_x)) {
					pos[0] = next_y;
					pos[1] = next_x;
				}
				else {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(pos[1] + " " + pos[0]);
	}
	static boolean isValid(int y, int x) {
		if(y<0 || y>=M) return false;
		if(x<0 || x>=M) return false;
		return true;
	}
}
