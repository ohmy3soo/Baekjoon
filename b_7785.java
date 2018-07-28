import java.util.*;
import java.io.*;

public class b_7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		HashMap<String, Boolean> hm = new HashMap<>();
		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			if(state.equals("enter"))
				hm.put(name, true);
			else if(state.equals("leave"))
				hm.put(name, false);
		}

		ArrayList<String> a = new ArrayList<>();
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			String next = it.next();
			if(hm.get(next)) a.add(next);
		}
		Collections.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		for(String name : a)
			sb.append(name + "\n");
		System.out.println(sb);
	}
}
