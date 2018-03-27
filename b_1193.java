import java.util.*;

public class b_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int k=1;
		while(X >= k*(k+1)/2+1)
			k++;
		int d = k*(k+1)/2 - X;

		int top , bottom;
		if(k%2 == 0)
			top = k-d;
		else
			top = 1+d;

		bottom = k+1-top;


		System.out.printf("%d/%d\n", top, bottom);



	}
}
