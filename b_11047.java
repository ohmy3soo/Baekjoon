import java.util.*;

public class b_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> S = new Stack<Integer>();
		int N = sc.nextInt();
		int K = sc.nextInt();

		for(int i=0; i<N; i++)
			S.push(sc.nextInt());

		int count = 0;
		while(!S.isEmpty() && K>0) {
			int money = S.pop();
			count += K/money;
			K %= money;
		}

		System.out.println(count);

	}
}
