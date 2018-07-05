import java.io.*;
import java.util.*;

public class b_9455 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[m][n];
			int ans = 0;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<n; j++)
					map[i][j] = (st.nextToken().equals("1"))? true : false; 
			}
			
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == true) {
						for(int k=i+1; k<m; k++) {
							if(map[k][j] == false) ans++;
						}
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
