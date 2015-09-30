package pl.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.constantsandstrings.Names_EN;
import pl.tables.ClientJTable;

public class ClientFrame implements ActionListener{
	JFrame clientFrame=new JFrame();
	ClientJTable clientJTable=new ClientJTable();
	JButton commiteButton=new JButton(Names_EN.CLIENTFRAME_COMMITEBUTTON);
	
	public ClientFrame() {
		super();
		defaultSettings();
		JScrollPane clientJTablePane=new JScrollPane(clientJTable);
		clientFrame.add(clientJTablePane);
		commiteButton.addActionListener(this);
		clientFrame.add(commiteButton);
	}

	public void defaultSettings(){
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.pack();
		clientFrame.setTitle(Names_EN.CLIENTFRAME_TITLEFRAME);
	}

	public void actionPerformed(ActionEvent e) {
		clientFrame.dispose();
		
	}
	
	
	
}
