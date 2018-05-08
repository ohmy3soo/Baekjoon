import java.io.*;
import java.util.*;

public class b_2412 {
	static ArrayList<Pos>[] y;
	static Queue<Pos> Q = new LinkedList<>();
	static int n;
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		y = new ArrayList[T+1];
		for(int i=0; i<T+1;i ++)
			y[i] = new ArrayList<>();

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int input_x = Integer.parseInt(st.nextToken());
			int input_y = Integer.parseInt(st.nextToken());
			Pos temp = new Pos(input_x, input_y);
			y[input_y].add(temp);
		}

		int step = 0;
		int len = 1;
		boolean find = false;
		Pos r = new Pos(0, 0);
		r.visit = true;
		y[0].add(r);
		Q.add(r);
		while(!Q.isEmpty()) {
			Pos pre = Q.poll();
			len--;
			if(pre.y == T) {
				find = true;
				break;
			}
			for(int i=-2; i<=2; i++) {
				for(int j=0; pre.y-i >=0 && pre.y-i<= T && j<y[pre.y-i].size(); j++) {
					if(Math.abs(y[pre.y-i].get(j).x-pre.x) <= 2 && y[pre.y-i].get(j).visit == false) {
						Q.add(y[pre.y-i].get(j));
						y[pre.y-i].get(j).visit = true;
					}
				}
			}
			if(len==0) {
				len = Q.size();
				step++;
			}
		}

		if(find)
			System.out.println(step);
		else
			System.out.println(-1);
	}
}

class Pos {
	int x;
	int y;
	boolean visit;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
		this.visit = false;
	}
}
