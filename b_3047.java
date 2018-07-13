import java.io.*;
import java.util.*;

public class b_3047 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(st.hasMoreTokens())
			arr.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(arr);
		
		String order = in.readLine();
		for(int i=0; i<order.length(); i++)
			sb.append(arr.get(order.charAt(i) - 'A') + " ");
		
		System.out.println(sb);
	}
}
