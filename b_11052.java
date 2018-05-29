import java.io.*;
import java.util.*;

public class b_11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for(int i=1; i<=N; i++) {
			int temp = 0;
			for(int j=1; j<=(i+1)/2; j++)
				temp = Math.max(temp, arr[j]+arr[i-j]);
			if(arr[i]<temp)
				arr[i] = temp;
		}
		System.out.println(arr[N]);

	}
}
