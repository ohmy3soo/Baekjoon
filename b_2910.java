import java.util.*;
import java.io.*;

public class b_2910 {
	static int N, C;
	static HashMap<Integer, Integer> hm;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();

		StringTokenizer st = new StringTokenizer(input);

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		hm = new LinkedHashMap<Integer, Integer>();

		st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			if(hm.containsKey(value))
				hm.replace(value, hm.get(value)+1);
			else
				hm.put(value, 1);
		}


		ArrayList<Integer> list = new ArrayList<Integer>(hm.keySet());

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				// 앞이 크면 1
				// 뒤가 크면 -1
				return hm.get(b).compareTo(hm.get(a));
			}
		});

		Iterator<Integer> I = list.iterator();

		while(I.hasNext()) {
			Integer value = I.next();
			for(int i=0; i<hm.get(value); i++)
				System.out.print(value + " ");
		}
	}
}
