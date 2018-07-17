package NA6_1;
import java.io.*;

public class b_1725 {
	static int[] h;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		h = new int[N];
		for(int i=0; i<N; i++)
			h[i] = Integer.parseInt(in.readLine());
		System.out.println(solve(0,N-1));
	}
	
	static int solve(int L, int R) {
		if(L==R) return h[L];
		
		int sl = (L+R)/2;
		int sr = (L+R)/2+1;
		
		int ret = Math.max(solve(L, sl), solve(sr, R));
		
		int height = Math.min(h[sl], h[sr]);
		ret = Math.max(ret, 2*height);
		while( L<sl || sr<R ) {
			if( sr < R && ( sl == L || h[sl-1] < h[sr+1]) ) height = Math.min(height, h[++sr]);
			else height = Math.min(height, h[--sl]);
			ret = Math.max(ret, (sr-sl+1)*height);
		}
		return ret;
	}
}
