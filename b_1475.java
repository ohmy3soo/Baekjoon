package step_by_step.step8;
import java.util.*;
import java.io.*;

public class b_1475 {
	
	static int[] num = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		
		for(int i=0; i<input.length(); i++)
			num[Integer.parseInt(input.substring(i, i+1))]++;
		
		num[6] = num[9] = (int)Math.ceil((num[6]+num[9])/2.0);
		
		int max = num[0];
		for(int i=0; i<10; i++)
			if(num[i] > max)
				max = num[i];
		
		System.out.println(max);
	}
}
