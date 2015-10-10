package pl.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.constantsandstrings.Names_EN;
import pl.tables.ClientJTable;

public class ChooseClientFrame implements ActionListener{
	JFrame clientFrame=new JFrame();
	ClientJTable clientJTable=new ClientJTable();
	JButton commiteButton=new JButton(Names_EN.CLIENTFRAME_COMMITE_BUTTON);
	
	public ChooseClientFrame() {
		super();
		defaultSettings();

		clientFrame.setLayout(new BorderLayout());
		JScrollPane clientJTablePane=new JScrollPane(clientJTable);
		clientFrame.add(clientJTablePane, BorderLayout.CENTER);
		
		commiteButton.addActionListener(this);
		clientFrame.add(commiteButton, BorderLayout.SOUTH);
	}

	public void defaultSettings(){
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.setSize(500, 600);
		clientFrame.setTitle(Names_EN.CLIENTFRAME_TITLE_FRAME);
	}

	public void actionPerformed(ActionEvent e) {

		clientFrame.dispose();
		
	}
	
	
	
}
