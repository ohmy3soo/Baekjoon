import java.io.*;
import java.util.*;

public class b_1005 {

	static Node[] node;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		StringTokenizer st;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			node = new Node[N+1];
			arr = new ArrayList[N+1];
			for(int j=1; j<=N; j++)
				arr[j] = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++)
				node[j] = new Node(Integer.parseInt(st.nextToken()));
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(in.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				arr[from].add(to);
			}

			int goal = Integer.parseInt(in.readLine());

			getMinTime(goal);
			sb.append(node[goal].min +"\n");
		}
		System.out.println(sb);
	}
	static void getMinTime(int idx) {

		for(int i=0; i<arr[idx].size(); i++) {
			if(node[arr[idx].get(i)].min < 0)
				getMinTime(arr[idx].get(i));
		}

		int max = 0;
		for(int i=0; i<arr[idx].size(); i++)
			max = Math.max(max, node[arr[idx].get(i)].min);
		node[idx].min = max + node[idx].time;
	}
}
class Node {
	int time;
	int min;

	public Node(int b) {
		this.time = b;
		this.min = Integer.MIN_VALUE;
	}
}
