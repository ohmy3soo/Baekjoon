import java.io.*;
import java.util.*;

public class b_1080 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[N][M][2];

		for(int t=0; t<2; t++) {
			for(int i=0; i<N; i++) {
				String line = in.readLine();
				for(int j=0; j<M; j++)
					arr[i][j][t] = line.charAt(j) - '0';
			}
		}


		int ans = 0;
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(arr[i-1][j-1][0] != arr[i-1][j-1][1]) {
					for(int m=i-1; m<=i+1; m++) {
						for(int n=j-1; n<=j+1; n++) {
							arr[m][n][0] = 1 - arr[m][n][0];
						}
					}
					ans++;
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j][0] != arr[i][j][1]) {
					ans = -1;
					break;
				}

			}
		}

		System.out.println(ans);

	}
}
