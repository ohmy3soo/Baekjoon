import java.util.*;
import java.io.*;

public class b_1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//TreeSet<Integer> visited = new TreeSet<>();
		final int MAX= 100001;
		boolean[] visited = new boolean[MAX];
		Queue<Integer> Q = new LinkedList<>();
		
		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(K < N) {
			System.out.println(N-K);
			return;
		}
		Q.add(N);
		for(int step=0; step<Integer.MAX_VALUE; step++) {
			int len = Q.size();
			
			for(int i=0; i<len; i++) {
				int node = Q.poll();	
				if(node == K) {
					System.out.println(step);
					return;
				}
				
				if(node < N/2)
					continue;
				
				// if(!visited.contains(node)) {
				if(!visited[node]) {
					if(node-1 >= 0)
						Q.add(node-1);
					if(node*2 < MAX)
						Q.add(node*2);
					if(node+1 < MAX)
						Q.add(node+1);
					
					//visited.add(node);
					visited[node] = true;
				}
			}
		}
		
	}
}
