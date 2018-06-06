import java.io.*;
import java.util.*;

public class b_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		ArrayList<String> arr = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			String input = in.readLine();
			if(hs.contains(input))
				continue;
			hs.add(input);
			arr.add(input);
		}
		Collections.sort(arr);

		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});

		for(int i=0; i<arr.size(); i++)
			sb.append(arr.get(i)+"\n");

		System.out.println(sb);
	}
}
