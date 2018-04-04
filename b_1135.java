import java.util.*;
import java.io.*;

public class b_1135 {

	static int N;
	static ArrayList<Integer>[] nodes;
	static Node[] p;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		nodes = new ArrayList[N];
		p = new Node[N];
		for(int i=0; i<N; i++) {
			nodes[i] = new ArrayList<Integer>();
			p[i] = new Node();
		}
		check = new boolean[N];

		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input);

		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent != -1) {
				nodes[parent].add(i);
			}
		}


		while(!allCheck()) {
			for(int i=0; i<N; i++) {
				if(nodes[i].size() == 0 || checkAllChildren(nodes[i])) {
					if(check[i])
						continue;
					check[i] = true;
					Collections.sort(nodes[i], new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return p[o2].value - p[o1].value;
						}
					});

					for(int j=0; j<nodes[i].size(); j++) {
						p[nodes[i].get(j)].value += j+1;
					}

					Collections.sort(nodes[i], new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return p[o2].value - p[o1].value;
						}
					});

					if(nodes[i].size() > 0)
						p[i].value = p[nodes[i].get(0)].value;

				}
			}
		}

		System.out.println(p[0].value);

	}
	public static boolean checkAllChildren(ArrayList<Integer> node) {
		for(int i=0; i<node.size(); i++) {
			if(check[node.get(i)] == false)
				return false;
		}
		return true;
	}
	public static boolean allCheck() {
		for(int i=0; i<N; i++) {
			if(check[i] == false)
				return false;
		}
		return true;
	}
}

class Node {
	int value = 0;
}
