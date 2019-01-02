package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import db.DBKudeatzaile;

public class Model2 extends AbstractTableModel{
	private Vector<Lag> data = new Vector<Lag>();
	private Vector<String> columnNames = new Vector<String>();

	public Model2() {
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
	

	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return columnNames.size();
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
	public Vector<Lag> getData(){
		return data;
	}
	public Lag getRow(int index) {
		return data.elementAt(index);
	}

}
