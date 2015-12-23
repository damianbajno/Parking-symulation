package pl.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.action.ParkingSpaceListener;
import pl.constantsandstrings.Names_PL;
import pl.dao.ClientDAO;
import pl.panel.CreateClientPanel;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class CreateClientFrame extends JFrame implements ActionListener{

	
	private CreateClientPanel createClientPanel;
	private JPanel panel=new JPanel(new BorderLayout());
	
	public CreateClientFrame() {
		createClientPanel=new CreateClientPanel();
		panel.add(createClientPanel.getPanel(), BorderLayout.CENTER);
		createButton(Names_PL.ADD_CLIENT_BUTTON_TITLE);
		createButton(Names_PL.EXIT);
		addButtonsToPanel();
		add(panel);
		defaultSettings();
	}

	public void defaultSettings() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	private JPanel buttonPanel=new JPanel(new FlowLayout());
	
	public void createButton(String text) {
		JButton button = new JButton(text);
		button.setActionCommand(text);
		button.addActionListener(this);
		buttonPanel.add(button);
	}

	private void addButtonsToPanel() {
		panel.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonActionCommand = e.getActionCommand();
		if (Names_PL.EXIT==buttonActionCommand) {
			this.dispose();
		}
		if (Names_PL.ADD_CLIENT_BUTTON_TITLE==buttonActionCommand){
			Client client = createClientPanel.getClient();
//			ParkingSpace selectedParkingSpace = .getSelectedParkingSpace();
//			if (client!=null){
//				client.setParkingSpace(selectedParkingSpace);
//				ClientDAO.persist(client);
//			}
		}
			
	}


}

