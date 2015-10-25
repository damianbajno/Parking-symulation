package pl.threadManager;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ThreadCardPanel extends JPanel {
	ThreadTextBoard threadTextBoard = new ThreadTextBoard();
	ThreadGraph threadGraph=new ThreadGraph();
	
	public ThreadCardPanel() {
		defoultSettings();
		add(threadTextBoard);
	}

	public void defoultSettings() {
		setLayout(new BorderLayout());
	}
	
	
	
	

}
