import java.util.*;

public class b_1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		String result="";

		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x==1)
			result = day[y%7];
		else {
			for(int i=0; i<x; i++)
				y += month[i];
			result = day[y%7];
		}
		System.out.println(result);


	}
}
