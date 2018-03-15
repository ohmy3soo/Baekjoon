import java.util.*;

public class b_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			int input = sc.nextInt();
			if(input > max)
				max = input;
			sum += input;
		}

		System.out.println((double)sum/max*100/N);
	}
}
