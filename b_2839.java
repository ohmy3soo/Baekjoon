import java.util.*;

public class b_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int n1 = N/5, n2=-1;

		for(int i=n1; i>=0; i--) {
			if((N - (5*i))%3 ==0) {
				n1 = i;
				n2 = (N - (5*i))/3;
				break;
			}
		}
		if(n2 == -1)
			System.out.println("-1");
		else
			System.out.println(n1+n2);


	}
}
