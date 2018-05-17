import java.util.*;
import java.io.*;

public class b_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Node> a = new ArrayList<>();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			Node newNode = new Node(s, e);
			a.add(newNode);
		}

		Collections.sort(a, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.end == o2.end)
					return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});

		int time = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			Node node = a.get(i);
			if(node.start >= time) {
				count++;
				time = node.end;
			}
		}

		System.out.println(count);
	}
}
class Node {
	int start;
	int end;
	public Node(int s, int e) {
		start = s;
		end = e;
	}
}
