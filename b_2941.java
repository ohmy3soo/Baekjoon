import java.util.*;
import java.io.*;

public class b_2941 {
	static String[] arr = { 	"c=", "c-", "dz=", "d-",
							"lj", "nj", "s=", "z=" };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<input.length()-arr[i].length()+1; j++) {
				if(input.substring(j, j+arr[i].length()).equals(arr[i]))
					input = input.substring(0, j) + "X" + input.substring(j+arr[i].length(), input.length());
			}
		}

		System.out.println(input.length());
	}
}
