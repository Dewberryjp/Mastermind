import java.util.Scanner;

public class Player {
	Scanner scan = new Scanner(System.in);
	Player(){
		
	}
	public char[] getInput(String message) {
		System.out.println(message);
		char[] input = scan.next().toCharArray();
		return input;
	}
}
