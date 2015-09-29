package pl.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.pojo.Client;

public class ClientTableModel extends AbstractTableModel {

	List<Client> clientList=new ArrayList<Client>();
	
	public int getRowCount() {
		return clientList.size();
	}

	public int getColumnCount() {
		return Client.class.getDeclaredFields().length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return Client.class.getDeclaredFields()[column].getName();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	
}
