import java.util.*;

public class b_5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int time=0;
		for(int i=0; i<input.length(); i++) {
			int temp = input.charAt(i)-'A';
			if(temp < 3)
				time += 2;
			else if(temp < 6)
				time += 3;
			else if(temp < 9)
				time += 4;
			else if(temp < 12)
				time += 5;
			else if(temp < 15)
				time += 6;
			else if(temp < 19)
				time += 7;
			else if(temp <22)
				time += 8;
			else time += 9;
		}
		System.out.println(time+input.length());
	}
}
