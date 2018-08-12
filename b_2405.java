package p24_2;
import java.io.*;
import java.util.*;

public class b_2405 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arr.add(Integer.parseInt(in.readLine()));
		
		Collections.sort(arr);
		
		int ans = 0;
		for(int i=1; i<n-1; i++) {
			int mid = i;
			int temp1 = Math.abs(2*arr.get(mid) - arr.get(0) - arr.get(mid+1));
			int temp2 = Math.abs(arr.get(mid-1) + arr.get(n-1) - 2*arr.get(mid));
			int temp = Math.max(temp1, temp2);
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
		
	}
}
