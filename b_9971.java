import java.io.*;
import java.util.*;

public class b_9971 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String op = in.readLine();
			if(op.equals("ENDOFINPUT"))
				break;
			else if(op.equals("START")) {
				String input = in.readLine();
				for(int i=0; i<input.length(); i++) {
					char next = input.charAt(i);
					if(next < 'A' || next > 'Z')
						sb.append(next);
					else {
						if(next-5 < 'A')
							next = (char)('Z' + 1 - ('A' - (next - 5)));
						else next -= 5;
						sb.append(next);
					}
				}
			}
			
			op = in.readLine();
			if(op.equals("END")) sb.append("\n");
		}
		System.out.println(sb);
	}
}
