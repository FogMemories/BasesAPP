package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelDepartamentos extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idDepartamento;
	private JPanelEtiqueta idSupervisor;
	private JPanelEtiqueta idUbicacion;
	private JPanelEtiqueta nombreDepartamento;
	private JPanelButtons jPanelButtons;

	public JPanelDepartamentos(Controller control) {
		setSize( 500, 550);
		this.setBackground(Color.WHITE);
		initComponents(control);
		setVisible(true);
	}

	private void initComponents(Controller control) {
		JPanel panelContainer = new JPanel();
		GridLayout layout = new GridLayout(5,1);
		panelContainer.setBackground(Color.WHITE);
		panelContainer.setBorder(new RoundBorder(50));
		panelContainer.setLayout(layout);
		panelContainer.	setVisible(true);

		idDepartamento = new JPanelEtiqueta("		id departamento");
		idDepartamento.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idDepartamento);

		idSupervisor = new JPanelEtiqueta("		id supervisor");
		idSupervisor.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idSupervisor);

		idUbicacion = new JPanelEtiqueta("		id ubicacion");
		idUbicacion.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idUbicacion);

		nombreDepartamento = new JPanelEtiqueta("		nombre departamento");
		nombreDepartamento.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(nombreDepartamento);

		jPanelButtons = new JPanelButtons(ComandApp.ADD_DEPARTAMENTO.name(), 
				ComandApp.MOSTRAR_DEPARTAMENTO.name(), ComandApp.MODIFICAR_DEPARTAMENTO.name(), 
				ComandApp.ELIMINAR_DEPARTAMENTO.name(),control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}

	public int getIdDepartamento() {
		return Integer.parseInt(idDepartamento.getTxtEtiqueta());
	}

	public int getidSupervisor() {
		return Integer.parseInt(idSupervisor.getTxtEtiqueta());
	}
	
	public int getidUbicacion() {
		return Integer.parseInt(idUbicacion.getTxtEtiqueta());
	}

	public String getnombreDepartamento() {
		return nombreDepartamento.getTxtEtiqueta();
	}
}