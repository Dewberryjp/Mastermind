import java.util.Random;

public class Mastermind {
	private int maxGuesses = 10;
	private int sequenceLength = 4;
	private Player user= new Player(); 
	private char[] colors = {'R','O','Y','G','B','P'};
	
	public void startGame() {
		char[] sequence=generateSequence();
		System.out.println("Welcome To Mastermind!");
		System.out.println(sequence);
		for(int currGuess=0;currGuess<maxGuesses;currGuess++) {
			 	char[] guess=user.getInput("Enter guess number "+currGuess);
			 	char[] pegs = checkGuess(sequence,guess);
			 	System.out.println(pegs);
			 	if(isWin(pegs)) {
			 		System.out.println("You Won!!! You are a Mastermind!!!");
			 		return;
			 	}
		}
		System.out.println("Loser");
		return;
	}

	public void initGame() {
		
	}
	/**
	 * 
	 * @return Pseudo-randomly generated sequence 
	 */
	private char[] generateSequence(){
		Random rng=new Random();
		char[] sequence=new char[sequenceLength];
		for(int j=0;j<sequenceLength;j++) {
			sequence[j]=colors[rng.nextInt(colors.length)];
		}
		
		return sequence;
	}
	private boolean isWin(char[] pegs) {
		for(char peg:pegs) {
			if(peg != 'B') return false;
		}
		return true;
	}
	private char[] checkGuess(char[] hiddenSequence,char[] guess) {
		boolean contains = false;
		char[] answerPegs=new char[sequenceLength];
		for(int j=0;j<sequenceLength;j++) {
			if(hiddenSequence[j] == guess[j]) {
				answerPegs[j]='B';
			} else {
				for(int k=0;k<sequenceLength;k++) {
					if(guess[j]==hiddenSequence[k]) {
						answerPegs[j]='W';
						contains=true;
						break;
					}
				}
				if(!contains) {
					answerPegs[j]='N';
				}
			}
		}
		return answerPegs;
	}
}
