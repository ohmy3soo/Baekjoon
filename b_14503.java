import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14503 {
	static int N, M;
	static int[][] map;
	static int posX, posY, dir;
	static int[][] next = { {-1,0}, {0,1}, {1,0}, {0,-1} };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		
		StringTokenizer st = new StringTokenizer(input);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		input = in.readLine();
		st = new StringTokenizer(input);
		
		posX = Integer.parseInt(st.nextToken());
		posY = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			input = in.readLine();
			st = new StringTokenizer(input);
			for(int j=0; j<M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		map[posX][posY] = -1;
		int count = 1;
		
		while(true) {
			boolean move = false;
			for(int i=0; i<4; i++) {
				dir = (dir+3)%4;
				int nextX = posX + next[dir][0];
				int nextY = posY + next[dir][1];
				
				if(map[nextX][nextY] == 0){
					posX = nextX;
					posY = nextY;
					map[posX][posY] = -1;
					count++;
					move = true;
					break;
				}
			}
			if(move == true)
				continue;
			
			posX += next[(dir+2)%4][0];
			posY += next[(dir+2)%4][1];
			
			if(map[posX][posY] == 1) {
				System.out.println(count);
				return;
			}
			
			
		}
	}
}
		
