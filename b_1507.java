import java.io.*;
import java.util.*;

public class b_1507 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] FW = new int[N][N];
		boolean[][] map = new boolean[N][N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				FW[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int m=0; m<N; m++) {
				for(int n=0; n<N; n++) {
					if(m==i || n==i) continue;
					if(FW[m][n] == FW[m][i] + FW[i][n]) {
						map[m][n] = true;
					}
					if(FW[m][n] > FW[m][i] + FW[i][n]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == false)
					ans += FW[i][j];
			}
		}
		System.out.println(ans/2);
	}
}
