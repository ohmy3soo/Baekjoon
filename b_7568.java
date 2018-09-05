import java.io.*;
import java.util.*;

public class b_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		ArrayList<Node_7568> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr.add(new Node_7568(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		
		for(int i=0; i<N; i++) {
			int count = 1;
			for(int j=0; j<N; j++) {
				if(arr.get(i).w < arr.get(j).w && arr.get(i).h < arr.get(j).h) {
					count++;
				}
			}
			sb.append(count + " ");
		}
		System.out.println(sb);
	}
}

class Node_7568 {
	int w, h;
	public Node_7568(int w, int h) {
		this.w = w;
		this.h = h;
	}
}
