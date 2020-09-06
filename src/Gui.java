import javax.swing.*;

public class Gui extends JFrame {
	
	Gui(){
		createJFrame();
	}
	
	private void createJFrame() {
		JFrame frame = new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.setVisible(true);
	}
}
