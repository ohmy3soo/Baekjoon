import java.util.*;

public class b_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int newN = (N%10*10) + (N/10 + N%10)%10;
		int count = 1;

		while(newN != N) {
			newN = (newN%10*10) + (newN/10 + newN%10)%10;
			count++;
		}

		System.out.println(count);
	}
}
