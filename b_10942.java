import java.util.*;

public class b_10942 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] DP = new boolean[N+1][N+1];
		
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			DP[i][i] = true;
		
		
		for(int i=1; i<=N-1; i++) {
			if(arr[i] == arr[i+1])
				DP[i][i+1] = true;
		}
		
		for(int k=2; k<=N-1; k++) {
			for(int i=1; i+k<=N; i++) {
				int j = i+k;
				if(arr[i] == arr[j] && DP[i+1][j-1] == true)
					DP[i][j] = true;
			}
		}
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			if(DP[from][to] == true)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		
	}
}
