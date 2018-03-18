import java.util.*;

public class b_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] alp = new int[26];
		for(int i=0; i<26; i++)
			alp[i] = -1;
		for(int i=0; i<input.length(); i++) {
			if(alp[input.charAt(i)-'a'] == -1)
				alp[input.charAt(i)-'a'] = i;
		}
		for(int i=0; i<26; i++)
			System.out.printf(alp[i] + " ");
	}
}
