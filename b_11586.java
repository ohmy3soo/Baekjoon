import java.util.*;
import java.io.*;

public class b_11586 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		
		
		for(int i=0; i<N; i++) {
			String row = in.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = row.charAt(j);
			}
		}
		
		int K = Integer.parseInt(in.readLine());
		
		if(K==1) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					out.append(map[i][j]);
				}
				out.append('\n');
				out.flush();
			}
		}
		if(K==2) {
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					out.append(map[i][j]);
				}
				out.append('\n');
				out.flush();
			}
		}
		if(K==3) {
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<N; j++) {
					out.append(map[i][j]);
				}
				out.append('\n');
				out.flush();
			}
		}
		
		out.close();
		
	}
}
