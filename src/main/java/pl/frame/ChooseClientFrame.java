package pl.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.action.ParkingSpaceListener;
import pl.button.ParkingSpaceButton;
import pl.constantsandstrings.Names_PL;
import pl.dao.ClientDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.tables.ClientJTable;

public class ChooseClientFrame implements ActionListener{
	private JFrame clientFrame=new JFrame();
	private ClientJTable clientJTable=new ClientJTable();
	private JButton commitButton=new JButton(Names_PL.CLIENT_FRAME_COMMIT_BUTTON);
	
	public ChooseClientFrame() {
		super();
		defaultSettings();

		clientFrame.setLayout(new BorderLayout());
		JScrollPane clientJTablePane=new JScrollPane(clientJTable);
		clientFrame.add(clientJTablePane, BorderLayout.CENTER);
		
		commitButton.addActionListener(this);
		clientFrame.add(commitButton, BorderLayout.SOUTH);
	}

	public void defaultSettings(){
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.setSize(500, 600);
		clientFrame.setTitle(Names_PL.CLIENT_TITLE_FRAME);
	}

	public void actionPerformed(ActionEvent e) {
		Client selectedClient = clientJTable.getSelectedClient();
//		ParkingSpace selectedParkingSpace = ParkingSpaceListener.getSelectedParkingSpace();
//		selectedClient.setParkingSpace(selectedParkingSpace);
//		ClientDAO.persist(selectedClient);
		clientFrame.dispose();
		
	}
	
	
	
}
