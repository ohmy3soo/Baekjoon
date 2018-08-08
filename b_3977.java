package NA11_1;
import java.io.*;
import java.util.*;

public class b_3977 {
	
	static ArrayList<Integer>[] arr;
	static ArrayList<ArrayList<Integer>> SCC;
	static int cnt, s_idx;
	static int[] sn, dfsn;
	static boolean[] finish;
	static Stack<Integer> S;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr = new ArrayList[N];
			for(int i=0; i<N; i++)
				arr[i] = new ArrayList<>();
			SCC = new ArrayList<>();
			cnt=0;
			s_idx=0;
			sn = new int[N];
			dfsn = new int[N];
			finish = new boolean[N];
			S = new Stack<>();
			
			int M = Integer.parseInt(st.nextToken());
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				arr[A].add(B);
			}
			
			for(int i=0; i<N; i++)
				if(dfsn[i] == 0) DFS(i);
			
			indegree = new int[s_idx];
			for(int i=0; i<s_idx; i++) {
				ArrayList<Integer> nSCC = SCC.get(i);
				for(int node : nSCC) {
					for(int n=0; n<arr[node].size(); n++) {
						int next = arr[node].get(n);
						if(sn[node] != sn[next]) indegree[sn[next]]++;
					}
				}
			}
			int idx = -1;
			for(int i=0; i<s_idx; i++) {
				if(indegree[i] == 0) {
					if(idx == -1) idx =i;
					else {
						idx = -1;
						break;
					}
				}
			}
			
			if(idx == -1) sb.append("Confused\n");
			else {
				Collections.sort(SCC.get(idx));
				for(int n : SCC.get(idx))
					sb.append(n + "\n");
			}
			sb.append("\n");
			if(t != T-1) in.readLine();
		}

		System.out.println(sb);
		
	}
	static int DFS(int n) {
		dfsn[n] = ++cnt;
		S.add(n);
		
		int result = dfsn[n];
		for(int next : arr[n]) {
			if(dfsn[next] == 0) result = Math.min(result, DFS(next));
			else if(!finish[next]) result = Math.min(result, dfsn[next]);
		}
		
		if(result == dfsn[n]) {
			ArrayList<Integer> curSCC = new ArrayList<>();
			while(true) {
				int next = S.pop();
				curSCC.add(next);
				finish[next] = true;
				sn[next] = s_idx;
				if(next == n) break;
			}
			SCC.add(curSCC);
			s_idx++;
		}
		
		return result;
	}
}
