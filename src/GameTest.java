import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		Game m = new Game(); 
		m.runGame(new MastermindCLI());
		
	}

}
