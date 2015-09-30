package pl.frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.constantsandstrings.Names_EN;
import pl.tables.ClientJTable;

public class ClientFrame {
	JFrame clientFrame=new JFrame();
	ClientJTable clientJTable=new ClientJTable();
	
	public ClientFrame() {
		super();
		defaultSettings();
		JScrollPane clientJTablePane=new JScrollPane(clientJTable);
		clientFrame.add(clientJTablePane);
	}

	public void defaultSettings(){
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.pack();
		clientFrame.setTitle(Names_EN.CLIENTFRAME_TITLEFRAME);
	}
}
