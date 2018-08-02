package Floyd;
import java.io.*;
import java.util.*;

public class b_1389 {
	static final int INF = 500_000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++)
			Arrays.fill(map[i], INF);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			map[A][B] = 1;
			map[B][A] = 1;
		}
		
		for(int m=1; m<=N; m++)
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					map[i][j] = Math.min(map[i][j], map[i][m] + map[m][j]);
		
		int[] step = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				step[i] += map[i][j];
			}
		}
		
		int ans = 1;
		for(int i=1; i<=N; i++)
			if(step[ans] > step[i]) ans = i;
		
		System.out.println(ans);
	}
}
