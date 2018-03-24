import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1790 {
	static int N;
	static long k;
	static long[] arr = new long[10];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();

		StringTokenizer st = new StringTokenizer(input);

		N = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());


		int length=0;
		for(length=1; length<10; length++) {
			long itv = length * (long)Math.pow(10, (length-1));
			arr[length] = 9 * itv + arr[length-1];
			if(k < arr[length])
				break;
		}

		// length 자리 수
		long base = (long)Math.pow(10, (length-1));

		k -= arr[length-1] + 1;		// k = length자리의 수 중 첫번째 수의 첫번째 자리


		long num = (long)k/length;
		long idx = k % length;

		long result = base + num;
		if(result > N) {
			System.out.println(-1);
			return;
		}

		String s = String.valueOf(result);
		System.out.println(s.charAt((int)idx));

	}
}
