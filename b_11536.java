import java.util.*;

public class b_11536 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.next();

		// 같으면 0, 앞이 크면 1, 뒤가 크면 -1 반환
		int mark = arr[0].compareTo(arr[1]);
		for(int i=1; i<N-1; i++) {
			int temp = arr[i].compareTo(arr[i+1]);
			if(temp*mark < 0) {
				mark = 0;
				break;
			}
		}
		if(mark>0)
			System.out.println("DECREASING");
		if(mark==0)
			System.out.println("NEITHER");
		if(mark<0)
			System.out.println("INCREASING");
	}
}
