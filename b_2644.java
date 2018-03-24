import java.util.*;

public class b_2644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int p1 = sc.nextInt();
		Stack<Integer> q1 = new Stack<>();
		int p2 = sc.nextInt();
		Stack<Integer> q2= new Stack<>();

		int m = sc.nextInt();
		boolean[][] r = new boolean[n+1][n+1];

		for(int i=0; i<m; i++) {
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();

			r[input1][input2] = true;
		}


		q1.push(p1);
		for(int i=1; i<=n; i++) {
			if(r[i][q1.peek()] == true) {
				q1.push(i);
				i = -1;
			}
		}

		q2.push(p2);
		for(int i=1; i<=n; i++) {
			if(r[i][q2.peek()] == true) {
				q2.push(i);
				i = -1;
			}
		}

		int result = -1;
		OUTER:
		for(int i=0; i<q1.size(); i++) {
			for(int j=0; j<q2.size(); j++) {
				if(q1.get(i) == q2.get(j)) {
					result = i+j;
					break OUTER;
				}
			}
		}
		System.out.println(result);
	}

}
