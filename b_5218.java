import java.util.*;

public class b_5218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			String s1 = sc.next();
			String s2 = sc.next();

			System.out.print("Distances:");
			for(int j=0; j < s1.length(); j++) {
				int d = (s2.charAt(j)-'0') - (s1.charAt(j)-'0');
				//d = (int)s2.charAt(j) - (int)s1.charAt(j);
				if(d < 0)
					d += 26;
				System.out.print(" " + d);
			}
			System.out.println();
		}
	}
}
