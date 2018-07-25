import java.io.*;
import java.util.*;

public class b_2246 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		ArrayList<Node> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.d == o2.d)
					return o1.c-o2.c;
				return o1.d - o2.d;
			}
		});

		int ans = 1;
		int min = arr.get(0).c;
		for(int i=1; i<arr.size(); i++) {
			if(arr.get(i).c < min) {
				min = arr.get(i).c;
				ans++;
			}
		}
		System.out.println(ans);

	}
}

class Node {
	int d;
	int c;
	public Node(int d, int c) {
		this.d = d;
		this.c = c;
	}
}
