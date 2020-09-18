
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MastermindGUI implements MastermindInterface {
	char[] colors;
//	JFrame window;
	public MastermindGUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initGame(char[] colors) {
	    String[] commands = {
	            "Play",
	            "How To Play",
	            "Exit"};
	    
	        int choice;
	        
	        do {
	          choice = JOptionPane.showOptionDialog(
	              null, // No parent
	              "Welcome to Mastermind!", // Prompt message
	              "Mastermind", // Window title
	              JOptionPane.YES_NO_CANCEL_OPTION, // Option type
	              JOptionPane.QUESTION_MESSAGE, // Message type
	              null, // Icon
	              commands, // List of commands
	              commands[commands.length - 1]); // Default choice
	          switch (choice) {
	            case 0:
	         
	              return;
	            case 1:
	             // doLookupEntry();
	              break;
	            case 2:
	              System.exit(0);
	              break;
	            default: // Do nothing.
	          }
	        }
	        while (choice != commands.length - 1);
	        System.exit(0);
	}
	@Override
	public char[] makeMove(char[] sequence) {
		
		String[] commands = {
	            "",
	            "How To Play",
	            "Exit"};
	    
	        int choice;
	        
	        do {
	          choice = JOptionPane.showOptionDialog(
	              null, // No parent
	              "Welcome to Mastermind!", // Prompt message
	              "Mastermind", // Window title
	              JOptionPane.YES_NO_CANCEL_OPTION, // Option type
	              JOptionPane.QUESTION_MESSAGE, // Message type
	              null, // Icon
	              commands, // List of commands
	              commands[commands.length - 1]); // Default choice
	          switch (choice) {
	            case 0:
	              
	            case 1:
	             // doLookupEntry();
	              break;
	            case 2:
	              System.exit(0);
	              break;
	            default: // Do nothing.
	          }
	        }
	        while (choice != commands.length - 1);
	        System.exit(0);
			return sequence;
	}
	@Override
	public void endGame(boolean isWin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postMove(char[] pegs) {
		// TODO Auto-generated method stub
		
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
