package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import db.DBKudeatzaile;
import model.Lag;
import model.Model1;
import model.Model2;

public class UI_1 extends JFrame{
	private Model1 model1 = new Model1 ();
	private Model2 model2 = new Model2();
	private JButton sartuBotoia = new JButton("Sartu");
	private JButton kenduBotoia = new JButton("Kendu");
	private JButton gordeBotoia = new JButton("Gorde");
	
	public UI_1() {
		super("Azterketa 2016-2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTable table1 = new JTable (model1);
		JTable table2 = new JTable (model2);
		JScrollPane scrollpane1 = new JScrollPane(table1);
		JScrollPane scrollpane2 = new JScrollPane(table2);
		
		Container panela = this.getContentPane();
		BoxLayout bl = new BoxLayout(panela, BoxLayout.X_AXIS);
		panela.setLayout(bl);
		panela.add(sartuBotoia);
		panela.add(gordeBotoia);
		panela.add(kenduBotoia);
		
		this.getContentPane().add(scrollpane1, BorderLayout.WEST);
		this.getContentPane().add(panela, BorderLayout.CENTER);
		this.getContentPane().add(scrollpane2, BorderLayout.EAST);
		
		sartuBotoia.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = table1.getSelectedRow();
				Lag hautatua =  model1.getRow(index);
				model1.kenduElementua(index);
				model2.sartuElementua(hautatua);
				
			}
		});
		
		gordeBotoia.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DBKudeatzaile db = DBKudeatzaile.getInstantzia();
				Vector<Lag> datuak = model2.getData();
				db.execSQL("delete from datuak");
				int i = 0;
				String query;
				while (i<=datuak.size()-1) {
					query = "insert into datuak values(\"" + datuak.elementAt(i).getBalioa(0) + "\", \""+
							datuak.elementAt(i).getBalioa(1)+"\", \""+datuak.elementAt(i).getBalioa(2)+ "\", \""
							+ datuak.elementAt(i).getBalioa(3)+"\", \""+ datuak.elementAt(i).getBalioa(4) + "\";";
					i++;
				}
				
			}
		});
		
		kenduBotoia.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int index = table2.getSelectedRow();
				model2.kenduElementua(index);
				model1.sartuElementua(model2.getRow(index));
				
			}
		});
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		UI_1 pantailaNagusia = new UI_1();
		pantailaNagusia.setSize(300, 200);
		pantailaNagusia.pack();
		pantailaNagusia.setVisible(true);
	}

}
