package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelTrabajo extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idTrabajo;
	private JPanelEtiqueta tituloTrabajo;
	private JPanelEtiqueta salarioMinimo;
	private JPanelEtiqueta salarioMaximo;
	private JPanelButtons jPanelButtons;

	public JPanelTrabajo(Controller control) throws SQLException {
		setSize(500, 550);
		this.setBackground(Color.WHITE);
		initComponents(control);
	
		setVisible(true);
	}

	private void initComponents(Controller control) throws SQLException {
		JPanel panelContainer = new JPanel();
		GridLayout layout = new GridLayout(5,1);
		panelContainer.setBackground(Color.WHITE);
		panelContainer.setBorder(new RoundBorder(50));
		panelContainer.setLayout(layout);
		panelContainer.	setVisible(true);
		

		idTrabajo = new JPanelEtiqueta("		id trabajo");
		idTrabajo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idTrabajo);

		tituloTrabajo = new JPanelEtiqueta("		titulo trabajo");
		tituloTrabajo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(tituloTrabajo);

		salarioMinimo = new JPanelEtiqueta("		salario minimo");
		salarioMinimo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(salarioMinimo);

		salarioMaximo = new JPanelEtiqueta("		salario maximo");
		salarioMaximo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(salarioMaximo);


		jPanelButtons = new JPanelButtons(ComandApp.ADD_WORK.name(), 
				ComandApp.MOSTRAR_WORK.name(), ComandApp.MODIFICAR_WORK.name(), 
				ComandApp.ELIMINAR_WORK.name(),control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}

	public int getidTrabajo() {
		return Integer.parseInt(idTrabajo.getTxtEtiqueta());
	}

	public String gettituloTrabajo() {
		return tituloTrabajo.getTxtEtiqueta();
	}

	public double getSalarioMinimo() {
		return Double.parseDouble(salarioMinimo.getTxtEtiqueta());
	}

	public double getSalarioMaximo() {
		return Double.parseDouble(salarioMaximo.getTxtEtiqueta());
	}
}