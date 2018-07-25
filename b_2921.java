import java.io.*;

public class b_2921 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int ans = 0;
		for(int i=0; i<=N; i++)
			ans += 3*i*(i+1)/2;
		System.out.println(ans);
	}

}
