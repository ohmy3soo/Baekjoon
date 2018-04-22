import java.util.*;
import java.io.*;

public class b_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		ArrayList<Node> a = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node newNode = new Node(x, y);

			a.add(newNode);
		}

		Collections.sort(a, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.x == o2.x)
					return o1.y - o2.y;
				else return o1.x - o2.x;
			}
		});

		for(Node node : a)
			System.out.println(node.x + " " + node.y);
	}
}
class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
