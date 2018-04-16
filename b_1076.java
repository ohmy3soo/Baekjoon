import java.util.*;
import java.io.*;

public class b_1076 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();

		hm.put("black", 0);
		hm.put("brown", 1);
		hm.put("red", 2);
		hm.put("orange", 3);
		hm.put("yellow", 4);
		hm.put("green", 5);
		hm.put("blue", 6);
		hm.put("violet", 7);
		hm.put("grey", 8);
		hm.put("white", 9);

		long Res = 0;

		Res = (10*hm.get(in.readLine()) + hm.get(in.readLine())) * (long)Math.pow(10, hm.get(in.readLine()));
		System.out.println(Res);
	}
}
