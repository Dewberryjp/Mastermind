import java.util.Scanner;

public class MastermindCLI implements MastermindInterface{
	Scanner scan = new Scanner(System.in);
	char[] colors;
	MastermindCLI(){

	}
	
	@Override
	public void initGame(char[] colors) {
		this.colors=colors;
		System.out.println("Welcome To Mastermind!");
		String help = getStrInput("Would you like to know how to play? (Y/N)");
		for(;;) {
			if("y".equalsIgnoreCase(help)) {
				System.out.println("How to Play");
				isPlayerReady();					
				return;
			} else if ("n".equalsIgnoreCase(help)){
				System.out.println("Someone is already a Mastermind then!");
				isPlayerReady();
				return;
			} else {
				help = getStrInput("Please enter 'Y' or 'N'.");
			}
		}
	}

	@Override
	public char[] makeMove(char[] sequence) {
		char[] guess;
		for(;;) {
			guess=getCharInput("Enter a Guess");
			if(guess.length != sequence.length) {
				guess=getCharInput("Please enter a guess that is "+sequence.length+" charachters long");
			} else if(!isValidCode(guess)){
				guess=getCharInput("Please enter a guess that only contains the characters "+String.valueOf(colors)+".");
			} else {
				//System.out.println(guess);
				return guess;
			}
		}
	}

	@Override
	public void postMove(char[] pegs) {
		System.out.println("Pegs: " + String.valueOf(pegs));
	}
	@Override
	public void endGame(boolean isWin) {
		if(isWin) {
			System.out.println("Congrats you won!");
		} else {
			System.out.println("Better luck next time!");
		}
	}
	private char[] getCharInput(String message) {
		System.out.println(message);
		char[] input = scan.nextLine().toCharArray();
		return input;
	}
	private String getStrInput(String message) {
		System.out.println(message);
		String input = scan.nextLine();
		return input;
	}
	private boolean isPlayerReady() {
		String rdy=getStrInput("When you are ready to play enter 'Y'. If you would like to quit enter 'Q'.");
		for(;;) {
			if("y".equalsIgnoreCase(rdy)) {
				return true;
			} else if ("q".equalsIgnoreCase(rdy)){
				System.exit(0);

			} else {
				rdy = getStrInput("Please enter 'Y' or 'N'.");
			}
		}
	}
	private boolean isValidCode (char[] code) {
		boolean valid;
		for(char c:code) {
			valid=false;
			for(char color:colors) {
				if(Character.toUpperCase(c) == Character.toUpperCase(color)) {
					valid=true;
					break;
				} 	
			}
			if(!valid) {
				return false;
			}
		}
		return true;
	}
}
