import java.io.*;
import java.util.*;

public class b_2873 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];

		for(int i=0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int m=0, n=1;
		if(R%2==0 && C%2 ==0) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if((i+j)%2 ==1 && map[i][j] < map[m][n]) {
						m = i;
						n = j;
					}
				}
			}
		}
		else {
			m = R+1;
			n = C+1;
		}

		int x=0, y=0;
		while(y != R-1 || x!= C-1) {
			if(y == m || y == m-1) {
				while(x < n-1) {
					sb.append("DRUR");
					x += 2;
				}
				if(y==m)
					sb.append("DR");
				else
					sb.append("RD");
				x++;
				y++;
				while(x < C-1) {
					sb.append("RURD");
					x += 2;
				}

				if(y == R-1 && x == C-1)
					break;
				sb.append('D');
				for(int i=1; i<C; i++)
					sb.append('L');
				sb.append('D');
				x = 0;
				y += 2;
				continue;
			}

			if(y == R-1) {
				for(int i=1; i<C; i++) {
					sb.append('R');
					x++;
				}
			}

			else if(y == R-2) {
				while(x < C-2) {
					sb.append("DRUR");
					x+=2;
				}
				sb.append('D');
				y++;
			}

			else {
				for(int i=1; i<C; i++)
					sb.append('R');
				sb.append('D');
				for(int i=1; i<C; i++)
					sb.append('L');
				sb.append('D');
				y += 2;
			}
		}
		System.out.println(sb);
	}
}
