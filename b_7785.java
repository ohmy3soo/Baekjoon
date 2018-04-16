import java.util.*;
import java.io.*;

public class b_7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<String> a = new ArrayList<>();
		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			if(state.equals("enter"))
				a.add(name);
			else if(state.equals("leave"))
				a.remove(name);
		}

		Collections.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		for(String name : a)
			System.out.println(name);
	}
}
