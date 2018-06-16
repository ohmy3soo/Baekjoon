package p15;
import java.io.*;
import java.util.*;

public class b_1774 {
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		Point[] p = new Point[N];
		root = new int[N];
		Arrays.fill(root, -1);
		
		int M = Integer.parseInt(st.nextToken());
		int count = M;
		double ans = 0;
		
		ArrayList<Node> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			p[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			merge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(find(i) != find(j))
					arr.add(new Node(i, j, getDistance(p[i], p[j])));
			}
		}
		
		Collections.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.distance, o2.distance);
			}
		});
		
		for(int j=0; j<arr.size(); j++) {
			int p1 = arr.get(j).idx1;
			int p2 = arr.get(j).idx2;
			if(merge(p1,p2)) {
				count++;
				ans += arr.get(j).distance;
			}
			if(count == N-1) break;
		}
		
		System.out.printf("%.2f", ans);
		
	}
	public static boolean merge(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return false;
		
		root[a] += root[b];
		root[b] = a;
		return true;
	}
	
	public static int find(int a) {
		if(root[a] < 0) return a;
		root[a] = find(root[a]);
		return root[a];
	}
	
	public static double getDistance(Point p1, Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
	}
}

class Point {
	long x;
	long y;
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

class Node {
	int idx1;
	int idx2;
	double distance;
	public Node(int p1, int p2, double d) {
		this.idx1 = p1;
		this.idx2 = p2;
		this.distance = d;
	}
}