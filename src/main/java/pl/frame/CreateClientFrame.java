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
import pl.panels.CreateClientPanel;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class CreateClientFrame extends JFrame implements ActionListener{

	
	private CreateClientPanel createClientPanel;
	private JPanel panel=new JPanel(new BorderLayout());
	
	public CreateClientFrame() {
		createClientPanel=new CreateClientPanel();
		panel.add(createClientPanel.getPanel(), BorderLayout.CENTER);
		createButton(Names_PL.CreateClientFrame_ADD_CLIENT_BUTTON);
		createButton(Names_PL.CreateClientFrame_EXIT);
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
		if (Names_PL.CreateClientFrame_EXIT==buttonActionCommand) {
			this.dispose();
		}
		if (Names_PL.CreateClientFrame_ADD_CLIENT_BUTTON==buttonActionCommand){
			Client client = createClientPanel.getClient();
			ParkingSpace selectedParkingSpace = ParkingSpaceListener.getSelectedParkingSpace();
			if (client!=null){
				client.setParkingSpace(selectedParkingSpace);
				ClientDAO.persist(client);
			}
		}
			
	}


}

