import java.util.*;

public class b_11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while(input.length() / 10 > 0) {
			System.out.println(input.substring(0, 10));
			input = input.substring(10);
		}
		System.out.println(input);
	}
}
