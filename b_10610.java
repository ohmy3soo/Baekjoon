import java.io.*;
import java.util.*;

public class b_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = in.readLine();
		Integer[] arr = new Integer[input.length()];

		boolean hasZero = false;
		int sum = 0;
		for(int i=0; i<input.length(); i++) {
			arr[i] = input.charAt(i) - '0';
			if(arr[i] == 0)
				hasZero = true;
			sum += arr[i];
		}
		if(hasZero && sum%3 == 0) {
			Arrays.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			});
			for(int i=0; i<arr.length; i++)
				sb.append(arr[i]);
			System.out.println(sb);

		}
		else
			System.out.println(-1);

	}
}
