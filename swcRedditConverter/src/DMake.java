
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * Usage: enter the amount of lines of code of file as an integer
 * click enter
 * copypaste the entire file in
 * tada!
 * @author Merrycatch22
 *
 */
public class DMake {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		input.useDelimiter(Pattern.compile("(\\n)"));
		String array[] = new String[x];

		for (int i = 0; i < x; i++) {
			array[i] = input.next();
		}
		
		System.out.printf("\n");
		
		for (int j = 0; j < x; j++) {
			for (int k = 0; k < array[j].length() - 9; k++) {
				if (array[j].substring(k, k + 6).equals("public") == true) {
					print(array[j]);
				} else if (array[j].substring(k, k + 7).equals("private") == true) {
					print(array[j]);
				}
				else if (array[j].substring(k, k + 9).equals("protected") == true) {
					print(array[j]);
				}
			}
		}

		input.close();
	}

	public static void print(String s) {

		StringBuilder sb = new StringBuilder(s);
		
		while (sb.indexOf("\t") != -1) {
			sb.deleteCharAt(sb.indexOf("\t"));
		}
		while (sb.indexOf(";") != -1) {
			sb.deleteCharAt(sb.indexOf(";"));
		}
		while (sb.indexOf("{") != -1) {
			sb.deleteCharAt(sb.indexOf("{"));
		}
		
		System.out.print(sb);
	}

}
