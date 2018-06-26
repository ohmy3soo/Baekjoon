import java.io.*;
import java.util.*;

public class b_6118 {
	static int[] dist;
	static boolean[] visit;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] arr = new ArrayList[N+1];
		dist = new int[N+1];
		visit = new boolean[N+1];

		for(int i=1; i<N+1; i++)
			arr[i] = new ArrayList<>();

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		visit[1] = true;
		int cost = 0;
		int count = 0;
		int limit = q.size();
		while(!q.isEmpty()) {
			if(count == limit) {
				cost++;
				count = 0;
				limit = q.size();
			}
			int idx = q.poll();
			dist[idx] = cost;
			for(int i=0; i<arr[idx].size(); i++) {
				if(visit[arr[idx].get(i)] == false) {
					q.add(arr[idx].get(i));
					visit[arr[idx].get(i)] = true;
				}
			}
			count++;
		}

		int max = 0;
		int same = 1;
		for(int i=1; i<=N; i++) {
			if(dist[max] == dist[i])
				same++;
			if(dist[max] < dist[i]) {
				max = i;
				same = 1;
			}
		}
		System.out.println(max + " " + dist[max] + " " + same);
	}
}
