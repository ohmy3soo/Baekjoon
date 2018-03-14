import java.util.Scanner;

public class b_2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N-i+1; j++)
				System.out.print('*');
			System.out.println();
		}
	}
}
