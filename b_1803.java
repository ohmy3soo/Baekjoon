import java.io.*;
import java.util.*;

public class b_1803 {
	static int[] m_in;
	static int[] n_in;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] m_out = new int[m+1];
		int[] n_out = new int[n+1];
		m_in = new int[m+1];
		n_in = new int[n+1];

		int[] m_result = new int[m+1];
		Arrays.fill(m_result, -1);
		int[] n_result = new int[n+1];
		Arrays.fill(n_result, -1);

		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=m; i++) {
			int input = Integer.parseInt(st.nextToken());
			m_out[i] = input;
			n_in[input]++;
		}

		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			int input = Integer.parseInt(st.nextToken());
			n_out[i] = input;
			m_in[input]++;
		}

		Queue<Integer> mQ = new LinkedList<>();
		for(int i=1; i<=m; i++)
			if(m_in[i] == 0) mQ.add(i);

		Queue<Integer> nQ = new LinkedList<>();
		for(int i=1; i<=n; i++)
			if(n_in[i] == 0) nQ.add(i);


		while(!mQ.isEmpty()) {
			int from = mQ.poll();
			m_result[from] = 1;
			int to = m_out[from];
			n_result[to] = 0;
			m_in[n_out[to]]--;
			if(m_in[n_out[to]] == 0) mQ.add(n_out[to]);
		}

		while(!nQ.isEmpty()) {
			int from = nQ.poll();
			if(n_result[from] != -1) continue;
			n_result[from] = 1;
			int to = n_out[from];
			m_result[to] = 0;
			n_in[m_out[to]]--;
			if(n_in[m_out[to]] == 0) nQ.add(m_out[to]);
		}

		for(int i=1; i<=m; i++) {
			if(m_result[i] == -1) {
				m_result[i] = 1;
				n_result[m_out[i]] = 0;
			}
		}

		for(int i=1; i<=m; i++)
			System.out.print(m_result[i]);
		System.out.println();
		for(int i=1; i<=n; i++)
			System.out.print(n_result[i]);


	}

}
