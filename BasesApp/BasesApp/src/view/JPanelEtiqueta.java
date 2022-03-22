package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelEtiqueta extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblEtiqueta;
	private JTextField txtEtiqueta;

	public JPanelEtiqueta(String etiqueta) {
		GridLayout layout = new GridLayout(1,2);
		setLayout(layout);
		this.setBackground(Color.WHITE);
		initComponents(etiqueta);
		this.setVisible(true);
	}

	private void initComponents(String etiqueta) {
		lblEtiqueta = new JLabel(etiqueta);
		lblEtiqueta.setPreferredSize(new Dimension(45,30));
		this.add(lblEtiqueta);

		txtEtiqueta = new JTextField();
		txtEtiqueta.setPreferredSize(new Dimension(75,30));
		this.add(txtEtiqueta);
	}

	public void setLblEtiqueta(String lblEtiqueta) {
		this.lblEtiqueta.setText(lblEtiqueta); 
	}
	
	public String getTxtEtiqueta() {
		return txtEtiqueta.getText();
	}

}