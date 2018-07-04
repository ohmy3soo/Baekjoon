import java.io.*;

public class b_8911 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			String input = in.readLine();
			int idx = 0;
			int[] pos = {0, 0};
			int[] limit = {0, 0, 0, 0};		// y, x, -y, -x
			
			for(int i=0; i<input.length(); i++) {
				int ins = input.charAt(i);
				if(ins == 'L') idx = (idx==0)? 3: idx-1;
				else if(ins == 'R') idx = (idx==3)? 0: idx+1;
				else if(ins == 'F') {
					pos[0] += dir[idx][0];
					pos[1] += dir[idx][1];
				}
				else if(ins == 'B') {
					pos[0] -= dir[idx][0];
					pos[1] -= dir[idx][1];
				}
				
				limit[0] = Math.max(limit[0], pos[0]);
				limit[1] = Math.max(limit[1], pos[1]);
				limit[2] = Math.min(limit[2], pos[0]);
				limit[3] = Math.min(limit[3], pos[1]);
			}
			sb.append((limit[0]-limit[2])*(limit[1]-limit[3]) + "\n");
		}
		
		System.out.println(sb);
		
	}
}
