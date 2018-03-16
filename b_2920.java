import java.util.*;

public class b_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[9];
		for(int i=1; i<=8; i++)
			input[i] = sc.nextInt();

		for(int i=1; i<=8; i++) {
			if(i != input[i]) break;
			if(i == 8) {
				System.out.println("ascending");
				return;
			}
		}
		for(int i=1; i<=8; i++) {
			if(i != input[9-i]) break;
			if(i == 8) {
				System.out.println("descending");
				return;
			}
		}
		System.out.println("mixed");
	}
}
