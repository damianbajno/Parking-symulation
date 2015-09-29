package pl.frame;

import javax.swing.JFrame;

public class ClientFrame {
	JFrame clientFrame=new JFrame();
	
	public void defaultSettings(){
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.pack();
		clientFrame.setTitle();
	}
}
