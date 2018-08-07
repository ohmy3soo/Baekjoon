package NA11_1;
import java.io.*;
import java.util.*;

public class b_2150 {
	static ArrayList<Integer>[] arr;
	static ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();
	static int[] dfsn, sn;
	static boolean[] finish;
	static int cnt=0, s_idx=0;
	static Stack<Integer> S = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[V+1];
		for(int i=1; i<=V; i++)
			arr[i] = new ArrayList<>();
		
		dfsn = new int[V+1];
		sn = new int[V+1];
		finish = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr[A].add(B);
		}
		
		for(int i=1; i<=V; i++)
			if(dfsn[i] == 0) DFS(i);
		
		Collections.sort(SCC, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0) - o2.get(0);
			}
		});
		sb.append(SCC.size()+"\n");
		for(int i=0; i<SCC.size(); i++) {
			for(int j=0; j<SCC.get(i).size(); j++)
				sb.append(SCC.get(i).get(j) + " ");
			sb.append("\n");
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
		// 뽑아내기
		if(result == dfsn[n]) {
			ArrayList<Integer> curSCC = new ArrayList<>();
			while(true) {
				int node = S.pop();
				curSCC.add(node);
				finish[node] = true;
				sn[node] = s_idx;
				if(node == n) break;
			}
			Collections.sort(curSCC);
			curSCC.add(-1);
			SCC.add(curSCC);
			s_idx++;
		}
		return result;
	}
}
