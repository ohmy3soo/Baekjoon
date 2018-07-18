package NA8_1;
import java.io.*;
import java.util.*;

public class b_1219 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] arr = new ArrayList[N];
		for(int i=0; i<N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[s].add(new Node(e, -c));
		}
		
		int[] get = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			get[i] = Integer.parseInt(st.nextToken());
		
		long[] money = new long[N];
		Arrays.fill(money, Long.MIN_VALUE);
		
		money[startCity] = get[startCity];
		
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean[] visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<arr[j].size(); k++) {
					if(money[j] != Long.MIN_VALUE && money[arr[j].get(k).to] < money[j] + get[arr[j].get(k).to] + arr[j].get(k).cost) {
						money[arr[j].get(k).to] = money[j] +  get[arr[j].get(k).to] + arr[j].get(k).cost;
						if(i == N-1)
							Q.add(arr[j].get(k).to);
					}
				}
			}
		}
		
		boolean conn = false;
			
		while(!Q.isEmpty()) {
			int next = Q.poll();
			if(visit[next] == true) continue;
			visit[next] = true;
			if(next == endCity) {
				conn = true;
				break;
			}
			for(int i=0; i<arr[next].size(); i++)
				Q.add(arr[next].get(i).to);
		}
		
		if(money[endCity] == Long.MIN_VALUE) System.out.println("gg");
		else if(conn) System.out.println("Gee");
		else System.out.println(money[endCity]);
	
	}
}

class Node {
	int to, cost;
	public Node(int t, int c) {
		this.to = t;
		this.cost = c;
	}
}





