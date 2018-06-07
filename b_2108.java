import java.io.*;
import java.util.*;

public class b_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		float sum = 0;
		Node[] arr = new Node[8001];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<8001; i++)
			arr[i] = new Node(i);

		for(int i=0; i<N; i++) {
			int idx = Integer.parseInt(in.readLine()) + 4000;
			arr[idx].count++;
			list.add(idx-4000);
			sum += idx-4000;
		}

		float avg = sum/N;
		Collections.sort(list);
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});


		int ans1 = Math.round(avg);
		int ans2 = list.get(N/2);
		int ans3 = (arr[0].count == arr[1].count)? arr[1].idx-4000 : arr[0].idx-4000;
		int ans4 = list.get(list.size()-1) - list.get(0);

		sb.append(ans1+"\n"+ans2+"\n"+ans3+"\n"+ans4);
		System.out.println(sb);


	}
}
class Node {
	int idx;
	int count;
	public Node(int idx) {
		this.idx = idx;
		this.count = 0;
	}
}
