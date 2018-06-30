import java.io.*;

public class b_10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		boolean isPalindrome = true;
		for(int i=0; i<input.length()/2; i++) {
			if(input.charAt(i) != input.charAt(input.length()-1-i)) {
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome) System.out.println(1);
		else System.out.println(0);
	}
}
