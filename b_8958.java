import java.util.*;

public class b_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			String input = sc.next();
			int score[] = new int[input.length()];
			int index=0;
			int total=0;
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == 'O') {
					score[index++]++;
				}
				else
					index=0;
			}
			for(int j=0; j<score.length; j++) {
				total += (j+1)*score[j];
			}
			System.out.println(total);
		}
	}
}
