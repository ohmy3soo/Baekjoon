import java.io.*;
import java.util.*;

public class b_2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				// TODO Auto-generated method stub
				return map[o1.y][o1.x] - map[o2.y][o2.x];
			}
		});
		for(int i=0; i<N; i++)
			pq.add(new Pos(0, i));
		for(int i=0; i<N*N-N; i++) {
			Pos cur = pq.poll();
			if(cur.y < N-1)
				pq.add(new Pos(cur.y+1, cur.x));
		}
		Pos goal = pq.poll();
		System.out.println(map[goal.y][goal.x]);
		
	}
}
class Pos {
	int y;
	int x;
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}