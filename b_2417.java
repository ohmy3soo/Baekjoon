import java.io.*;
import java.util.*;

public class b_2417 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Long n = Long.parseLong(in.readLine());
		double result = Math.ceil(Math.sqrt(n));
		System.out.println((long)result);
	}
}
