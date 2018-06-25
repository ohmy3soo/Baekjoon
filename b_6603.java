import java.io.*;
import java.util.*;

public class b_6603 {
	static int[] num;
	static boolean[] visit;
	static Stack<Integer> s;
	static int k;
	static ArrayList<Integer>[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		s = new Stack<>();

		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0)
				break;

			num = new int[k];
			arr = new ArrayList[k];
			visit = new boolean[k];

			for(int i=0; i<k; i++)
				arr[i] = new ArrayList<>();

			for(int i=0; i<k; i++)
				num[i] = Integer.parseInt(st.nextToken());

			for(int i=0; i<k; i++) {
				for(int j=0; j<k; j++) {
					if(i==j) continue;
					arr[i].add(j);
				}
			}

			for(int i=0; i<k; i++)
				dfs(i);

			sb.append("\n");
		}

		System.out.println(sb);
	}
	static void dfs(int n) {
		if(visit[n] == true) return;

		visit[n] = true;
		s.add(n);
		if(s.size() == 6) {
			for(int t=0; t<6; t++)
				sb.append(num[s.get(t)] + " ");
			sb.append("\n");
			visit[s.pop()] = false;
			return;
		}
		for(int j=0; j<arr[n].size(); j++)
			if(n < arr[n].get(j)) dfs(arr[n].get(j));
		visit[s.pop()] = false;
	}
}
