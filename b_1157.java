import java.util.*;

public class b_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toLowerCase();
		int[] arr = new int[26];
		for(int i=0; i<input.length(); i++)
			arr[input.charAt(i)-'a']++;

		int max=0;
		boolean dup = false;
		for(int i=1; i<26; i++) {
			if(arr[i] == arr[max])
				dup = true;

			else if(arr[max] < arr[i]) {
				max = i;
				dup = false;
			}
		}
		if(dup)
			System.out.println('?');
		else
			System.out.println((char)(max+'A'));
	}
}
