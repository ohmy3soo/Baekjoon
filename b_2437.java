import java.io.*;
import java.util.*;

public class b_2437 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		Integer[] arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(in.readLine());

		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		int sum = 0;
		for(int i=0; i<N; i++) {
			if(sum+1<arr[i]) break;
			sum+=arr[i];
		}
		System.out.println(sum+1);

	}
}
