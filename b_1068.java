import java.io.*;
import java.util.*;

public class b_1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N];
		Queue<Integer> q = new LinkedList<>();

		for(int i=0; i<N; i++)
			arr[i] = new ArrayList<>();


		int root = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());

			if(input < 0) root = i;
			else arr[input].add(i);
		}

		int D = Integer.parseInt(in.readLine());
		if(D == root) {
			System.out.println(0);
			return;
		}

		int ans = 0;
		q.offer(root);
		while(!q.isEmpty()) {
			int idx = q.poll();
			int c = 0;
			for(int i=0; i<arr[idx].size(); i++) {
				if(arr[idx].get(i) != D) {
					q.offer(arr[idx].get(i));
					c++;
				}
			}
			if(c==0) ans++;
		}

		System.out.println(ans);

	}
}
