import java.util.*;
import java.io.*;

public class b_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();

		for(int i=0; i<N; i++)
			arr.add(Integer.parseInt(in.readLine()));


		Collections.sort(arr);

		for(int i=0; i<arr.size(); i++)
			System.out.println(arr.get(i));

		in.close();
	}
}
