package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelHistoryWork extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idEmpleado;
	private JPanelEtiqueta idTrabajo;
	private JPanelEtiqueta idDepartamento;
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private JPanelButtons jPanelButtons;

	public JPanelHistoryWork(Controller control) {
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

		idEmpleado = new JPanelEtiqueta("		id ubicacion");
		idEmpleado.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idEmpleado);
		
		idTrabajo = new JPanelEtiqueta("		id pais");
		idTrabajo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idTrabajo);

		idDepartamento = new JPanelEtiqueta("		direccion");
		idDepartamento.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idDepartamento);
		
		fechaInicio = new Fecha("seleccione la fecha", 70, 0);
		fechaInicio.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
		fechaInicio.setPreferredSize(new Dimension(75,20));
		panelContainer.add(fechaInicio);
		
		fechaFin = new Fecha("seleccione la fecha", 70, 0);
		fechaFin.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
		fechaFin.setPreferredSize(new Dimension(75,20));
		panelContainer.add(fechaFin);
		
		jPanelButtons = new JPanelButtons(ComandApp.ADD_HYSTORY_WORK.name(), 
				ComandApp.MOSTRAR_HYSTORY_WORK.name(), ComandApp.MODIFICAR_HYSTORY_WORK.name(), 
				ComandApp.ELIMINAR_HYSTORY_WORK.name(),control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}

	public int getidTrabajo() {
		return Integer.parseInt(idTrabajo.getTxtEtiqueta());
	}

	public int getidDepartamento() {
		return Integer.parseInt(idDepartamento.getTxtEtiqueta());
	}
	
	
	public int getidEmpleado() {
		return Integer.parseInt(idEmpleado.getTxtEtiqueta());
	}

	public Date getFechaFin() {
		return fechaFin.getDate();
	}
	
	public Date getFechaInicio() {
		return fechaInicio.getDate();
	}
}