import java.io.*;

public class b_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// (y+x) % 2 == 0 : 하얀 칸
		int ans = 0;
		for(int i=0; i<8; i++) {
			String line = in.readLine();
			for(int j=0; j<8; j++)
				if((i+j)%2 == 0 && line.charAt(j) == 'F') ans++;
		}
		System.out.println(ans);
	}
}
