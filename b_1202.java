package NA7_1;
import java.io.*;
import java.util.*;

public class b_1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Jewel> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			arr.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				// TODO Auto-generated method stub
				return o1.M - o2.M;
			}
		});
		
		int[] bag = new int[K];
		for(int i=0; i<K; i++)
			bag[i] = Integer.parseInt(in.readLine());
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		long ans = 0;
		int start = 0;
		for(int i=0; i<K; i++) {
			while(start < N && arr.get(start).M <= bag[i])
				pq.add(arr.get(start++).V);
			if(!pq.isEmpty()) ans += pq.poll();
		}
		System.out.println(ans);
		
	}
}

class Jewel {
	int M;
	int V;
	public Jewel(int m, int v) {
		this.M = m;
		this.V = v;
	}
}