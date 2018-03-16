import java.util.*;

public class b_4673 {
	public static void main(String[] args) {
		// int는 0으로 자동 초기화
		// boolean은 false로 자동 초기화
		int size = 10001;
		boolean[] arr = new boolean[size];


		for(int i=1; i<size; i++) {
			int idx = d(i);
			while(idx < size) {
				if(arr[idx] != false)
					break;
				arr[idx] = true;
				idx = d(idx);
			}
		}

		for(int i=1; i<size; i++) {
			if(arr[i] == false)
				System.out.println(i);
		}

	}
	public static int d(int n) {
		int result = n;
		while(n>0) {
			result += n%10;
			n /= 10;
		}
		return result;
	}
}
