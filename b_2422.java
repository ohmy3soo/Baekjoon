package p23;
import java.io.*;
import java.util.*;

public class b_2422 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int s = Math.min(a, b);
			int e = Math.max(a, b);
			arr[s].add(e);
		}
		
		int ans = 0;
		boolean[] visit = new boolean[N+1];
		// 첫번째 아이스크림 선택
		for(int ic1=1; ic1<=N-2; ic1++) {
			for(int i=0; i<arr[ic1].size(); i++)
				visit[arr[ic1].get(i)] = true;
			// 두번째 아이스크림 선택
			for(int ic2=ic1+1; ic2<=N-1; ic2++) {
				if(visit[ic2]) continue;
				for(int j=0; j<arr[ic2].size(); j++)
					visit[arr[ic2].get(j)] = true;
				
				// 세번째 아이스크림 선택
				for(int ic3=ic2+1; ic3<=N; ic3++)
					if(visit[ic3] != true)
						ans++;
				Arrays.fill(visit, false);
				for(int i=0; i<arr[ic1].size(); i++)
					visit[arr[ic1].get(i)] = true;
				
			}
			for(int i=0; i<arr[ic1].size(); i++)
				visit[arr[ic1].get(i)] = false;
		}
		System.out.println(ans);
	}
}
