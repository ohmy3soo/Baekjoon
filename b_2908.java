import java.util.*;

public class b_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		Stack<Character> a = new Stack<>();
		Stack<Character> b = new Stack<>();
		for(int i=0; i<3; i++) {
			a.push(A.charAt(i));
			b.push(B.charAt(i));
		}
		OUTER:
		for(int i=0; i<3; i++) {
			/*
			int d = a.peek() - b.peek();
			switch(d) {
				case 0:
					System.out.print(a.pop());
					b.pop();
					break;
				case 1:
					while(!a.isEmpty())
						System.out.print(a.pop());
					break OUTER;
				case -1:
					while(!a.isEmpty())
						System.out.print(b.pop());
					break OUTER;
			}
			*/

			if(a.peek() == b.peek()) {
				System.out.print(a.pop());
				b.pop();
			}
			else if(a.peek() > b.peek()) {
				while(!a.isEmpty())
					System.out.print(a.pop());
				break OUTER;
			}
			else {
				while(!b.isEmpty())
					System.out.print(b.pop());
				break OUTER;
			}
		}

	}
}
