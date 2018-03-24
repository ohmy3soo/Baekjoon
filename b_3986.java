import java.util.*;

public class b_3986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for(int i=0; i<N; i++) {
			String input = sc.next();
			Stack<Character> S = new Stack<>();
			for(int j=0; j<input.length(); j++) {
				if(S.size() > 0 && S.peek() == input.charAt(j))
					S.pop();
				else
					S.push(input.charAt(j));
			}
			if(S.isEmpty())
				count++;
		}
		System.out.println(count);

	}
}
