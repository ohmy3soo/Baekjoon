package step_by_step.step8;
import java.util.*;

public class b_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1 , 6, 12, 18 ...
		/*
		 * k = 1, layer=1
		 * a(n) = a(n-1) + 6(n-1)
		 */
		if(N==1) {
			System.out.println(1);
			return;
		}
		int end = 7;
		int layer = 2;
		while(N > end) {
			end = end + 6*layer;
			layer++;
		}
		System.out.println(layer);
	}
}
