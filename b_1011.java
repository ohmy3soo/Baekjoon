import java.util.*;

public class b_1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			int d = end-start;

			int idx = 0;

			for(int j=0; j<Integer.MAX_VALUE; j++) {
				idx += Math.ceil(j/2.0);

				if(d <= idx) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
