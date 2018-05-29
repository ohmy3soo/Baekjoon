import java.io.*;
import java.util.*;

public class b_2186 {

	static int N, M, K;
	static char[][] map;
	static int[][] DP, cost;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		cost = new int[N][M];
		DP = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		String s = in.readLine();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == s.charAt(s.length()-1))
					DP[i][j] = 1;
			}
		}

		for(int c=s.length()-1; c>0; c--) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(DP[i][j] != 0 && map[i][j] == s.charAt(c)) {
						for(int m=-K; m<=K; m++) {
							if(m==0)
								continue;
							if(i+m<N && i+m>=0 && map[i+m][j] == s.charAt(c-1))
								cost[i+m][j] += DP[i][j];
						}
						for(int n=-K; n<=K; n++) {
							if(n==0)
								continue;
							if(j+n<M && j+n>=0 && map[i][j+n] == s.charAt(c-1))
								cost[i][j+n] += DP[i][j];
						}
					}
				}
			}
			updateDP();
		}

		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == s.charAt(0))
					ans += DP[i][j];
			}
		}

		System.out.println(ans);
	}
	static void updateDP() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				DP[i][j] = cost[i][j];
				cost[i][j] = 0;
			}
		}
	}
}
