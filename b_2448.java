import java.util.*;
import java.io.*;

public class b_2448 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		String[] lines = new String[N];
		lines[0] = "  *  ";
		lines[1] = " * * ";
		lines[2] = "*****";
		String empty = "   ";

		for(int k=0; k<=10; k++) {
			int tempN = 3*(int)Math.pow(2, k);
			if(tempN == N)
				break;
			for(int i=tempN; i<2*tempN; i++) {
				lines[i] = lines[i-tempN] + " " + lines[i-tempN];
			}
			for(int i=0; i<tempN; i++){
				lines[i] = empty + lines[i] + empty;
			}
			empty = empty + empty;

		}


		for(int i=0; i<N; i++) {
			System.out.println(lines[i]);
		}

	}
}
