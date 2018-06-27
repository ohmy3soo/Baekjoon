import java.io.*;
import java.util.*;

public class b_2309 {

	static Stack<Integer> s = new Stack<>();
	static Integer[] arr;
	static boolean[] visit;
	static int sum = 0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new Integer[9];
		visit = new boolean[9];

		for(int i=0; i<9; i++)
			arr[i] = Integer.parseInt(in.readLine());

		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		// DFS
		for(int i=0; i<9; i++)
			dfs(i);

		while(!s.isEmpty())
			sb.append(arr[s.pop()] + "\n");

		System.out.println(sb);
	}
	static void dfs(int n) {
		if(visit[n] == true) return;

		visit[n] = true;
		s.add(n);
		sum += arr[n];
		if(s.size() == 7) {
			if(sum == 100) {
				flag = true;
				return;
			}
			int p = s.pop();
			sum -= arr[p];
			visit[p] = false;
			return;
		}

		for(int i=n+1; i<9; i++) {
			if(!flag) dfs(i);
			else return;
		}
		int p = s.pop();
		sum -= arr[p];
		visit[p] = false;
	}
}
