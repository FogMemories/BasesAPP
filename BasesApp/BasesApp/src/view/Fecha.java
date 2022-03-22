package view;

import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;

public class Fecha extends JDateChooser{

	private static final long serialVersionUID = 1L;
	
	
	public Fecha(String name, int x, int y) {
		this.setName(name);
		this.setPreferredSize(new Dimension(x,y));
	}
}