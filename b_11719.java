import java.util.Scanner;

public class b_11719 {
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		for(int i=0; i<100; i++) {
			String input = sc.nextLine();
			System.out.println(input);
			if(!sc.hasNext())
				break;
		}
	}
}
