import java.io.*;
import java.util.*;

public class b_1764 {
	// TreeMap < HashMap+Sort
	public static void main(String[] args) throws IOException {
		/*
		HashSet<String> hs = new HashSet<>();
		TreeSet<String> ts = new TreeSet<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++)
			hs.add(in.readLine());
		for(int i=0; i<M; i++) {
			String name = in.readLine();
			if(hs.contains(name))
				ts.add(name);
		}

		System.out.println(ts.size());
		for(String item : ts)
			System.out.println(item);
		*/

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<N; i++)
			hm.put(in.readLine(), 1);
		for(int i=0; i<M; i++) {
			String name = in.readLine();
			// int X
			Integer v = hm.get(name);
			if( v == null)
				v = 0;
			v += 2;
			hm.put(name, v);
		}

		ArrayList<String> a = new ArrayList<>();
		for( Map.Entry<String, Integer> entry : hm.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if(value == 3)
				a.add(key);
		}
		System.out.println(a.size());
		Collections.sort(a);
		for(String name : a)
			System.out.println(name);

	}
}
