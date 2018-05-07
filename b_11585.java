import java.io.*;
import java.util.*;

public class b_11585 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		char[] dinner = new char[N];
		for(int i=0; i<N; i++)
			dinner[i] = st.nextToken().charAt(0);
		char[] board = new char[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			board[i] = st.nextToken().charAt(0);
		
		int i=1;
		OUTER1:
		for(i=1; i<N; i++) {
			if(N%i == 0) {
				OUTER2:
				for(int j=0; j<N/i-1; j++) {		// 덩어리 번호
					for(int k=0; k<i; k++) {		// 덩어리 길이
						if(dinner[j*i+k] != dinner[(j+1)*i+k])
							break OUTER2;
					}
					if(j == N/i-2)
						break OUTER1;
				}
			}
		}
		System.out.println(1 + "/" + i);
	}
}
