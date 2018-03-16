import java.util.*;

public class b_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for(int i=1; i<=N; i++) {
			if(check(i))
				count++;
		}
		System.out.println(count);
	}
	public static boolean check(int n) {
		int d = n/10%10 - n%10;
		while(n/10 > 0) {
			int tempD = n/10%10 - n%10;
			n /= 10;
			if(d != tempD)
				return false;
		}
		return true;
	}
}
