package pl.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.hibernate.mapping.Column;

public class ClientJTable extends JTable {
	
	public ClientJTable(){
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		setModel(new ClientTableModel());
	}
}
