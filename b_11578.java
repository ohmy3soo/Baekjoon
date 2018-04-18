import java.io.*;
import java.util.*;

public class b_11578 {
	
	static int N,M;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int T = Integer.parseInt(st.nextToken());
			for(int j=0; j<T; j++)
				p[i] += Math.pow(2, N-(Integer.parseInt(st.nextToken())));
		}
		
		int min = M+1;
		for(int i=0; i<M; i++) {
			min = Math.min(min, BF(i, p[i], 1));
		}
		if(min == M+1)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	static int BF(int from, int mask, int depth) {
		if(mask == Math.pow(2, N) - 1)
			return depth;
		else {
			int min = M+1;
			for(int i=from+1; i<M; i++) {
				min = Math.min(min, BF(i, mask|p[i], depth+1));
			}
			return min;
		}
	}
}
