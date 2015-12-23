package pl.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

import pl.constantsandstrings.Names_PL;

public class StatisticThreadFrame extends JFrame {
	public StatisticThreadFrame() {
		defoultSetting();
		
	}

	public void defoultSetting() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(Names_PL.PARKING_TITLE_FRAME);
		setMinimumSize(new Dimension(600, 600));
		pack();
		setVisible(true);
	}
}
