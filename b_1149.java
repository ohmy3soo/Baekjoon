import java.io.*;
import java.util.*;

public class b_1149 {
	static int[][] RGB;
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		RGB = new int[N][3];
		DP = new int[N][3];
		int ans = Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			RGB[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}

		DP[0] = new int[] {RGB[0][0], RGB[0][1], RGB[0][2]};
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				DP[i][j] = getCost(i, j);
			}
		}

		for(int i=0; i<3; i++)
			ans = Math.min(ans, DP[N-1][i]);
		System.out.println(ans);

	}
	static int getCost(int idx, int color) {
		int temp = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(color != i) {
				temp = Math.min(temp, DP[idx-1][i]+RGB[idx][color]);
			}
		}
		return temp;
	}
}
