import java.util.*;
import java.io.*;

public class b_2376 {

	static int n;
	static boolean[] check;
	static ArrayList<Integer>[] next;
	static LinkedList<Node> node = new LinkedList<>();
	static ArrayList<Integer> route1 = new ArrayList<>();
	static ArrayList<Integer> route2 = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		check = new boolean[2*n-1];

		next = new ArrayList[2*n-1];
		for(int i=0; i<2*n-1; i++)
			next[i] = new ArrayList<>();

		for(int i=0; i<n-1; i++) {
			check[i*2] = true;
			node.add(new Node(i*2,(i*2+2), Integer.parseInt(in.readLine())));
		}
		check[2*(n-1)] = true;

		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int from = (Integer.parseInt(st.nextToken())-1)*2;
		int to = (Integer.parseInt(st.nextToken())-1)*2;

		Collections.sort(node, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.d - o2.d;
			}
		});

		for(int i=0; i<n-1; i++) {
			int index = getIndex(node.get(0).start, node.get(0).end);
			if(index == -1)
				break;

			next[node.get(0).start].add(index);
			next[node.get(0).end].add(index);

			check[index] = true;
			for(int j=1; j<node.size(); j++) {
				if(node.get(j).start == node.get(0).start) {
					node.get(j).start = index;
					node.get(j).d--;
				}
				else if(node.get(j).start == node.get(0).end) {
					node.get(j).start = index;
					node.get(j).d--;
				}

				else if(node.get(j).end == node.get(0).start) {
					node.get(j).end = index;
					node.get(j).d--;
				}
				else if(node.get(j).end == node.get(0).end) {
					node.get(j).end = index;
					node.get(j).d--;
				}

			}
			node.remove(0);
			Collections.sort(node, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.d - o2.d;
				}
			});
		}

		int temp = from;
		route1.add(temp);
		while(next[temp].size() != 0) {
			route1.add(next[temp].get(0));
			temp = next[temp].get(0);
		}

		temp = to;
		route2.add(temp);
		while(next[temp].size() != 0) {
			route2.add(next[temp].get(0));
			temp = next[temp].get(0);

			if(route1.contains(temp)) {
				System.out.println(route1.indexOf(temp) + route2.indexOf(temp));
				return;
			}

		}
		System.out.println(route1.size() + route2.size() -2);


	}

	public static int getIndex(int s, int e) {
		for(int i=s+1; i<e; i++) {
			if(check[i] == false)
				return i;
		}
		return -1;
	}
}

class Node {
	int start;
	int end;
	int d;

	public Node(int s, int e, int d) {
		this.start = s;
		this.end = e;
		this.d = d;
	}
}
