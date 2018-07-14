import java.util.*;
import java.io.*;

public class b_2252 {	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = new ArrayList<>();
		int[] to = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			arr[s1].add(s2);
			to[s2]++;
		}
		
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++)
			if(to[i] == 0) Q.add(i);
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!Q.isEmpty()) {
			int idx = Q.poll();
			result.add(idx);
			for(int i=0; i<arr[idx].size(); i++) {
				int next = arr[idx].get(i);
				to[next]--;
				if(to[next] == 0) Q.add(next); 
			}
		}
		for(int i=0; i<result.size(); i++)
			sb.append(result.get(i) + " ");
		System.out.println(sb);
	}
}
