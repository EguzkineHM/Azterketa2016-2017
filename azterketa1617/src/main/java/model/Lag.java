package model;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Lag {
	private String firstname;
	private String lastname;
	private String sport;
	private int numyears;
	private boolean vegetarian;
	private ImageIcon argazkia;
	
	public Lag (String firstname, String lastname, String sport, int numyears, boolean vegetarian) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.sport = sport;
		this.numyears = numyears;
		this.vegetarian = vegetarian;
		this.argazkia = kargatuArgazkia();
	}


	private ImageIcon kargatuArgazkia() {
		URL path = this.getClass().getResource("/images.jpeg");
		Image irudia = new ImageIcon(path).getImage();
		return new ImageIcon(irudia.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));
	}
	
	public Object getBalioa (int i) {
		switch(i) {
			case 0: return this.firstname;
			case 1: return this.lastname;
			case 2: return this.sport;
			case 3: return this.numyears;
			case 4: return this.vegetarian;
			case 5: return this.argazkia;
			default: return null;
		}
	}


	@Override
	public String toString() {
		return "Lag [firstname=" + firstname + ", lastname=" + lastname + ", sport=" + sport + ", numyears=" + numyears
				+ ", vegetarian=" + vegetarian + "]";
	}
	
	public void insertElementAt(Object value, int i){
		switch (i) {
			case 0: this.firstname = (String) value;
			break;
			case 1: this.lastname = (String) value;
			break;
			case 2: this.sport = (String) value;
			break;
			case 3: this.numyears = (Integer) value;
			break;
			case 4: this.vegetarian = (Boolean) value;
			break;
		}
	}

}
