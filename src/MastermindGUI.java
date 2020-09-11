
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JFrame;

public class MastermindGUI extends Mastermind {
	HashMap<String,Color> colorLinks = new HashMap<String,Color>();
	Color red = Color.BLACK;
	colorLinks.put("red",Color.BLACK);
	
	MastermindGUI() {
		// TODO Auto-generated constructor stub
	}
	public void startWindow() {
		JFrame window = new JFrame();
	}
	@Override
	public void startGame() {
		/*
		 * char[] sequence=generateSequence();
		 * System.out.println("Welcome To Mastermind!"); System.out.println(sequence);
		 * for(int currGuess=0;currGuess<maxGuesses;currGuess++) { char[]
		 * guess=user.getInput("Enter guess number "+currGuess); char[] pegs =
		 * checkGuess(sequence,guess); System.out.println(pegs); if(isWin(pegs)) {
		 * System.out.println("You Won!!! You are a Mastermind!!!"); return; } }
		 * System.out.println("Loser"); return;
		 */
	}
}
