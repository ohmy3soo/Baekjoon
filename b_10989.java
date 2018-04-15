import java.io.*;
import java.util.*;

public class b_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 100001;
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[MAX];

		for(int i=0; i<N; i++)
			arr[Integer.parseInt(in.readLine())]++;

		//int count = 0;
		for(int i=0; i<MAX; i++) {
			if(arr[i] != 0) {
				for(int j=0; j<arr[i]; j++) {
					out.append(i + "\n");
					//count++;
				}
			}
			//if(count == N)
			//	break;
		}

		out.flush();
		in.close();
		out.close();
	}
}
