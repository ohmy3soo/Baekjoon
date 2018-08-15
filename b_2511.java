import java.io.*;
import java.util.*;

public class b_2511 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(in.readLine());
		StringTokenizer st2 = new StringTokenizer(in.readLine());

		Stack<Character> result = new Stack<>();
		int A=0, B=0;
		for(int i=0; i<10; i++) {
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(a>b) {
				A+=3;
				result.push('A');
			}
			else if(a<b) {
				B+=3;
				result.push('B');
			}
			else {
				A+=1;
				B+=1;
				result.push('D');
			}
		}
		System.out.println(A + " " + B);
		if(A > B) System.out.println("A");
		else if(A < B)System.out.println("B");
		else {
			while(!result.isEmpty()) {
				char w = result.pop();
				if(w != 'D') {
					System.out.println(w);
					return;
				}
			}
			System.out.println("D");
		}

	}
}
