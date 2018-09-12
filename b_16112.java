import java.io.*;
import java.util.*;

public class b_16112 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(arr);
		
		long atv = 0;
		long ans =0 ;
		for(int i=0; i<n; i++) {
			ans += arr.get(i) * atv;
			if(atv < k)
				atv++;
		}
		System.out.println(ans);
		
	}
}
