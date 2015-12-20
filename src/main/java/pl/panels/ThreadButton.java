package pl.panels;

import java.awt.Dimension;

import javax.swing.JButton;

import org.hibernate.metamodel.domain.Superclass;

public class ThreadButton extends JButton {

    public ThreadButton(String text) {
	super(text);
	setPreferredSize(new Dimension(30, 50));
    }
}
