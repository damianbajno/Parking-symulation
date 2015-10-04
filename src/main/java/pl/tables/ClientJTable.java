package pl.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.hibernate.mapping.Column;

import pl.pojo.Client;

public class ClientJTable extends JTable {
	ClientTableModel clientTableModel;
	
	public ClientJTable(){
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		clientTableModel = new ClientTableModel();
		setModel(clientTableModel);
	}
	
//	public Client getSelectedClient(){
//	}
}
