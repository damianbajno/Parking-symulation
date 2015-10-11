package pl.panels;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.tools.GBC;
import pl.tools.Tools;

public class CreateClientPanel {

	private static final int textFildWidth = 20;
	private JLabel nameLabel = new JLabel("Imie");
	private JLabel surNameLabel = new JLabel("Nazwisko");

	private JTextField nameTextField = new JTextField(textFildWidth);
	private JTextField surNameTextField = new JTextField(textFildWidth);

	private Client client;
	
	public CreateClientPanel() {

	}

	public JPanel getPanel() {
		JPanel parkingSpacePanel = new JPanel();

		parkingSpacePanel.setLayout(new GridBagLayout());
		parkingSpacePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createBevelBorder(3), "Pracownik"));

		parkingSpacePanel.add(nameLabel, new GBC(0, 0).setAnchor(GBC.WEST)
				.setIpad(10, 10));
		parkingSpacePanel.add(nameTextField, new GBC(1, 0));

		parkingSpacePanel.add(surNameLabel, new GBC(0, 1).setAnchor(GBC.WEST)
				.setIpad(10, 10));
		parkingSpacePanel.add(surNameTextField, new GBC(1, 1));

		return parkingSpacePanel;
	}

	public Client getClient() {
		if (areFieldsCorrectlyFilled()) {
			createClientFromTextFields();
			return client;
		}
		return null;
	}

	public boolean areFieldsCorrectlyFilled() {
		if (Tools.isText(nameTextField.getText())
				&& Tools.isText(surNameTextField.getText())) {
			return true;
		} else {
			Tools.showMessage();
			return false;
		}
	}

	private void createClientFromTextFields() {
		client = new Client();
		client.setName(nameTextField.getText());
		client.setSurName(surNameTextField.getText());
	}

	public void clearTextFields() {
		nameTextField.setText("");
		surNameTextField.setText("");
	}
}
