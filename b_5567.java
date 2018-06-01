import java.io.*;
import java.util.*;

public class b_5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		boolean[] check = new boolean[n+1];
		check[1] = true;
		for(int i=1; i<n+1; i++)
			arr[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		int ans = 0;
		for(int i=0; i<arr[1].size(); i++) {
			int next = arr[1].get(i);
			if(check[next] == false) {
				check[next] = true;
				ans++;
			}
			for(int j=0; j<arr[next].size(); j++) {
				if(check[arr[next].get(j)] == false) {
					check[arr[next].get(j)] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
