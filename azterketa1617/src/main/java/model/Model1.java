package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import db.DBKudeatzaile;

public class Model1 extends AbstractTableModel {
	
	private Vector<Lag> data = new Vector<Lag>();
	private Vector<String> columnNames = new Vector<String>();

	public Model1() {
		kargatu();
	}
	
	public void kargatu() {
		//sqltik hartu datuak
		String query = "select firstname, lastname, sport, numyears, vegetarian"
				+ "from datuak;";
		DBKudeatzaile db = DBKudeatzaile.getInstantzia();
		ResultSet rs = db.execSQL(query);
		kargatuDaudenak(rs);
		hasieratuZutabeIzenak();
	}
	
	private void hasieratuZutabeIzenak() {
		columnNames.add("First Name");
		columnNames.add("Last Name");
		columnNames.add("Sport");
		columnNames.add("# ofYears");
		columnNames.add("Vegetarian");
		columnNames.add("Argazkia");
	}
	
	private void kargatuDaudenak(ResultSet rs) {
		try {
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String sport = rs.getString("sport");
				int numyears = rs.getInt("numyears");
				Boolean vegetarian = rs.getBoolean("vegetarian");
				
				data.add(new Lag(firstname, lastname, sport, numyears, vegetarian) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return columnNames.size();
	}
	
	public Lag getRow(int index) {
		return data.elementAt(index);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	public void sartuElementua(Lag elem) {
		data.addElement(elem);
	}
	public void kenduElementua(int index) {
		data.remove(index);
	}

}
