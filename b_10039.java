import java.util.*;

public class b_10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i=0; i<5; i++) {
			int input = sc.nextInt();
			if(input > 40)
				sum+=input;
			else sum+=40;
		}
		System.out.println(sum/5);
	}
}
