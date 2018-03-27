]import java.util.*;
import java.io.*;

public class b_2775 {
	static int[][] map = new int[15][15];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());


		initializeMap();

		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());

			System.out.println(map[k][n]);
		}
	}
	public static int getCount(int k, int n) {
		if(map[k][n] != 0)
			return map[k][n];
		if(k == 0)
			return n;
		if(n == 0)
			return 0;
		return getCount(k-1, n) + getCount(k,n-1);
	}
	public static void initializeMap() {
		for(int i=1; i<15; i++) {
			for(int j=1; j<15; j++) {
				map[i][j] = getCount(i,j);
			}
		}
	}
}
