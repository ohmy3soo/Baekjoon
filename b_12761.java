package NA7_1;
import java.io.*;
import java.util.*;

public class b_12761 {
	static boolean[] visit = new boolean[100_001];
	static int A, B, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] move1 = { 1, -1, A, -A, B, -B };
		int[] move2 = { A, B };
		
		System.out.println(bfs(move1, move2));
		
	}
	static int bfs(int[] m1, int[] m2) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(N);
		visit[N] = true;
		
		int cost = 0;
		int count = 1;
		while(!Q.isEmpty()) {
			int x = Q.poll();
			count--;
			for(int i=0; i<m1.length; i++) {
				int next = x + m1[i];
				if(next>=0 && next<=100_000 && visit[next] == false) {
					if(next == M) return cost+1;
					visit[next] = true;
					Q.add(next);
				}
			}
			for(int i=0; i<m2.length; i++) {
				int next = x * m2[i];
				if(next>=0 && next<=100_000 && visit[next] == false) {
					if(next == M) return cost+1;
					visit[next] = true;
					Q.add(next);
				}
			}
			if(count == 0) {
				count = Q.size();
				cost++;
			}
		}
		return -1;
	}
}
