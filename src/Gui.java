import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui implements ActionListener,MastermindInterface {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private int count=0;
	
	public Gui(){
		createJFrame();
	}
	
	private void createJFrame() {
		frame=new JFrame();
		frame.setSize(new Dimension(300,200));
		JButton button = new JButton("Click Me");
        button.addActionListener(this);
        label=new JLabel("I'm a label");
        // the panel with the button and text
        //JPanel panel = new JPanel();
        //panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.setLayout(new GridLayout(0, 1));
        button.setBounds(20, 70, 100, 50);
        frame.add(button);
        frame.add(label);
        // set up the frame and display it
        //frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
        return;
	}
class MyPanel extends JPanel{
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawString("", arg1, arg2);
		}
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: "+count);
	}

	@Override
	public void initGame(char[] colors) {
		
	}

	@Override
	public char[] makeMove(char[] sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endGame(boolean isWin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postMove(char[] pegs) {
		// TODO Auto-generated method stub
		
	}
}
