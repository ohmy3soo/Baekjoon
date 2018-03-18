import java.util.*;

public class b_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;

		for(int i=0; i<N; i++) {
			String input = sc.next().trim();
			boolean[] visited = new boolean[26];
			for(int j=0; j<input.length(); j++) {
				if(visited[input.charAt(j)-'a'] == true)
					if(input.charAt(j-1) != input.charAt(j))
						break;
				visited[input.charAt(j)-'a'] = true;

				if(j == input.length()-1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
