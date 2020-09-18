import java.util.Scanner;

public class MastermindCLI implements MastermindInterface{
	Scanner scan = new Scanner(System.in);
	char[] colors;
	MastermindCLI(){

	}
	/**
	 * Method to 
	 */
	@Override
	public void initGame(char[] colors) {
		this.colors=colors;
		System.out.println("Welcome To Mastermind!");
		String help = getStrInput("Would you like to know how to play? (Y/N)");
		for(;;) {
			if("y".equalsIgnoreCase(help)) {
				System.out.println("The Code-Maker(cpu) creates a random code of letters representing colors.");
				System.out.println("You will have 10 guesses to guess the code.");
				System.out.println("Each time you enter a guess, you will be shown a white peg for each color");
				System.out.println("you guessed that is in the code. A black peg for a letter being the right color");
				System.out.println("and in the right spot. The order of these pegs does not relate to the order of the guess.");
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
	/**
	 * Method to take player's guess as input validate it and return it.
	 * Guess length must be equal to hidden sequence length 
	 * and must contain only the valid colors.
	 * @param The randomly generated sequence
	 * @return The
	 */
	@Override
	public char[] makeMove(char[] sequence) {
		char[] guess;
		for(;;) {
			guess=getCharInput("Enter a Guess (Guess length must be "+sequence.length+" characters long, and consist of the letters "+String.valueOf(colors)+").");
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
	/**
	 * Method to Keep track of previous moves.
	 */
	@Override
	public void postMove(char[] pegs) {
		System.out.println("Pegs: " + String.valueOf(pegs));
	}
	/**
	 * Controls what the user sees when the game is over.
	 */
	@Override
	public void endGame(boolean isWin) {
		if(isWin) {
			System.out.println("Congrats you won!");
		} else {
			System.out.println("Better luck next time!");
		}
	}
	/**
	 * Method to output a message and take input as a char array
	 * @param message String to print before taking input
	 * @return Char array that was input.
	 */
	private char[] getCharInput(String message) {
		System.out.println(message);
		char[] input = scan.nextLine().toCharArray();
		return input;
	}
	/**
	 * Method to output a message and take input as a string
	 * @param message String to print before taking input
	 * @return String that was input
	 */
	private String getStrInput(String message) {
		System.out.println(message);
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Method to check if player is ready to play. 
	 * @return True if player enters Y. Exit's on N.
	 */
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
	/**
	 * Method to validate code input.
	 * Check's if the code contains only the colors allowed.
	 * @param code Code Breaker's guess
	 * @return true if it is a valid code, false if it is not
	 */
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
