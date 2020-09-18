import java.util.Random;

public class Game {
	private final int maxGuesses = 10;
	private final int sequenceLength = 4;
	private char[] colors = {'R','O','Y','G','B','P'};
	
	/**
	 * 
	 * @param colors Array of colors to be used in Mastermind
	 */
	Game(){
		
	} 
	
	//replace start game with calls to a gui class and a console based class.

	public void runGame(MastermindInterface m) {
		char[] sequence=generateSequence();
		
		m.initGame(colors);
		for(int currGuess=0;currGuess<maxGuesses;currGuess++) {
//			 	char[] guess=user.getInput("Enter guess number "+currGuess);
			 	
//			 	System.out.println(pegs);
				char[] guess=m.makeMove(sequence);
				char[] pegs=checkGuess(sequence, guess);
				m.postMove(pegs);
			 	if(isWin(pegs)) {
			 		m.endGame(true);
			 	
			 		return;
			 	}
		}
		m.endGame(false);

		return;
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
		//boolean contains = false;
		char[] answerPegs=new char[sequenceLength];
		for(int j=0;j<sequenceLength;j++) {
			if(hiddenSequence[j] == guess[j]) {
				answerPegs[j]='B';
			} else {
				for(int k=0;k<sequenceLength;k++) {
					if(Character.toUpperCase(guess[j])==Character.toUpperCase(hiddenSequence[k])) {
						answerPegs[j]='W';
						//contains=true;
						break;
					}
				}
				//if(!contains) {
					
				//}
			}
		}
		return randomizePegs(answerPegs);
	}
	private char[] randomizePegs(char[] pegs) {
		Random rng = new Random();
		
		for(int j=0;j<pegs.length;j++) {
			int swap = rng.nextInt(pegs.length);
			char temp = pegs[swap];
			pegs[swap]=pegs[j];
			pegs[j] = temp;
		}
		return pegs;
	}
	public char[] getColors() {
		return colors;
	}
}
