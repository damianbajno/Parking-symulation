package pl.tables;
 
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import pl.dao.ClientDAO;
import pl.pojo.Client;

public class ClientJTable extends JTable {
	ClientTableModel clientTableModel;
	
	public ClientJTable(){
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		clientTableModel = new ClientTableModel();
		setModel(clientTableModel);
	}
	
	public Client getSelectedClient(){
		int selectedRowNumber = this.getSelectedRow(); 
		Client client = ClientDAO.get(selectedRowNumber);
		return client;
	}
}
