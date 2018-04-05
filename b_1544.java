import java.util.*;
import java.io.*;

public class b_1544 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		ArrayList<String> words = new ArrayList<>();
		OUTER:
		for(int i=0; i<N; i++) {
			String input = in.readLine();
			for(int j=0; j<words.size(); j++) {
				String word = words.get(j);
				for(int k=0; k<word.length(); k++) {
					if(word.equals(input))
						continue OUTER;
					word = word.substring(1) + word.substring(0, 1);
				}
			}
			words.add(input);
		}
		System.out.println(words.size());
	}
}
