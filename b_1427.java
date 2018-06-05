import java.io.*;
import java.util.*;

public class b_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();

		while(N != 0) {
			arr.add(N%10);
			N /= 10;
		}

		Collections.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		for(int i=0; i<arr.size(); i++)
			sb.append(arr.get(i));

		System.out.println(sb);
	}
}
