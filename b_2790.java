import java.io.*;
import java.util.*;

public class b_2790 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		Integer score[] = new Integer[N];

		for(int i=0; i<N; i++)
			score[i] = Integer.parseInt(in.readLine());

		Arrays.sort(score, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		int count = 1;
		score[0]++;
		int max = score[0];
		for(int i=1; i<N; i++) {
			if(score[i]+N >= max) {
				count++;
				score[i] += i+1;
				max = Math.max(max, score[i]);
			}
		}
		System.out.println(count);
	}
}
