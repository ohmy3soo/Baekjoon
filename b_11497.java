import java.io.*;
import java.util.*;

public class b_11497 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(in.readLine());
			Integer[] arr = new Integer[N];
			Deque<Integer> dq = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			for(int i=0; i<N; i++) {
				if(i%2==0) dq.addFirst(arr[i]);
				else dq.addLast(arr[i]);
			}
			
			int ans = Math.abs(dq.peekFirst() - dq.peekLast());
			for(int i=0; i<N-1; i++) {
				int idx = dq.pollFirst();
				ans = Math.max(ans, Math.abs(idx-dq.peekFirst()));
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
