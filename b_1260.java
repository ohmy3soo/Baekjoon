import java.util.*;

public class b_1260 {
	static boolean[] visited;
	static LinkedList<Integer>[] header;
	static Queue<Integer> Q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		visited = new boolean[N+1];
		
		header = (LinkedList<Integer>[])new LinkedList[N+1];
		//header = new LinkedList[N+1];
		
		for(int i=1; i<N+1; i++)
			header[i] = new LinkedList<Integer>();
		
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			header[v1].add(v2);
			header[v2].add(v1);
		}
		
		for(int i=1; i<N+1; i++)
			Collections.sort(header[i]);
		
		dfs(V);
		System.out.println();
		for(int i=1; i<N+1; i++)
			visited[i] = false;
		bfs(V);
			
	}
	
	public static void dfs(int V) {
		visited[V] = true;
		System.out.print(V + " ");
		for(int nextV:header[V]) {
			if(visited[nextV] == false)
				dfs(nextV);
		}
	}
	
	public static void bfs(int V) {
		visited[V] = true;
		System.out.print(V + " ");
		Q.add(V);
		while(!Q.isEmpty()) {
			int nextV = Q.poll();
			for(int child:header[nextV]) {
				if(visited[child] != true) {
					visited[child] = true;
					System.out.print(child + " ");
					Q.add(child);
				}
			}
		}
		
	}
}

