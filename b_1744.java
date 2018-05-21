import java.io.*;
import java.util.*;

/*
 * 다시 풀어보기!
 * 0인 경우 1인 경우를 센 다음,
 * 부호에 따른 리스트의 길이에 따라
 * 1이나 0을 추가 해준다. (길이를 짝수개로 맞춰준다.)
 * 이러면 범위 실수를 줄일 수 있다.
 */


public class b_1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> p = new ArrayList<>();
		ArrayList<Integer> m = new ArrayList<>();

		int ans = 0;

		for(int i=0; i<N; i++) {
			int v = Integer.parseInt(in.readLine());
			if(v>0)
				p.add(v);
			else
				m.add(v);
		}

		Collections.sort(p, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		for(int i=0; i<p.size(); i++) {
			if(i == p.size()-1)
				ans += p.get(i);
			else if(p.get(i+1) == 1)
				ans += p.get(i);
			else {
				ans += p.get(i) * p.get(i+1);
				i++;
			}
		}


		Collections.sort(m);
		for(int i=0; i<m.size(); i++) {
			if(i == m.size()-1)
				ans += m.get(i);
			else {
				ans += m.get(i) * m.get(i+1);
				i++;
			}
		}

		System.out.println(ans);

	}
}
