import java.util.*;

public class b_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i=0; i<T; i++) {
			int R = sc.nextInt();
			String S = sc.nextLine().trim();
			String result="";
			for(int j=0; j<S.length(); j++)
				for(int k=0; k<R; k++)
					result = result.concat(S.substring(j, j+1));
			System.out.println(result);
		}
	}
}
