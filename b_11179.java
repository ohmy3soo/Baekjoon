import java.util.*;

public class b_11179 {
	public static void main(String[] args) {
		final int e = 2;

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Stack<Integer> S = new Stack<Integer>();

		while(N>0) {
			S.push(N%e);
			N /= e;
		}

		int result=0;
		int k=1;
		while(!S.isEmpty()) {
			result += k * S.pop();
			k *= e;
		}
		System.out.println(result);
	}
}
