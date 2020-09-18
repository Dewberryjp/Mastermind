
public interface MastermindInterface {
	/**
	 * Method to show the welcome screen/menu of the game
	 * @return
	 */
	public void initGame(char[] colors);
	/**
	 * Method to make a single move in Mastermind.
	 * @return
	 */
	public char[] makeMove(char[] sequence);
	
	/**
	 * Method to control what happens when the player wins/loses.
	 */
	public void endGame(boolean isWin);
	/**
	 * 
	 * @param pegs
	 */
	public void postMove(char[] pegs);
	
	
}
