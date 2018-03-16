import java.util.*;

public class b_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		input = input.trim();
		if(input.equals("")) {
			System.out.println("0");
			return;
		}
		String[] list = input.split(" ");

		System.out.println(list.length);
	}
}
