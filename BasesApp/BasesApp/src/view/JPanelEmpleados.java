package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelEmpleados extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idEmpleado;
	private JPanelEtiqueta idDepartamento;
	private JPanelEtiqueta idSupervisor;
	private JPanelEtiqueta nombreEmpleado;
	private JPanelEtiqueta apellidoEmpleado;
	private JPanelEtiqueta email;
	private JPanelEtiqueta telefono;
	private Fecha fechaContrato;
	private JPanelEtiqueta salario;
	private JPanelEtiqueta comision;
	private JPanelEtiqueta idtrabajo;

	private JPanelButtons jPanelButtons;

	public JPanelEmpleados(Controller control) {
		setSize( 600, 800);
		this.setBackground(Color.WHITE);
		initComponents(control);
		this.setLayout(new GridLayout(2,1));
		setVisible(true);
	}

	private void initComponents(Controller control) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBackground(Color.WHITE);
		GridLayout layout = new GridLayout(5,2);
		panelContainer.setSize( 800, 700);
		panelContainer.setLayout(layout);
		panelContainer.	setVisible(true);
		
		JPanel panelContainerSouth = new JPanel();
		GridLayout layoutB = new GridLayout(2,1);
		panelContainerSouth.setSize( 800, 300);
		panelContainerSouth.setLayout(layoutB);
		panelContainerSouth.setBorder(BorderFactory.createEmptyBorder(50, 30, 40, 30));
		panelContainerSouth.setVisible(true);

		idEmpleado = new JPanelEtiqueta("		id empleado");
		idEmpleado.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idEmpleado);

		idDepartamento = new JPanelEtiqueta("		id departamento");
		idDepartamento.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idDepartamento);

		idSupervisor = new JPanelEtiqueta("		id supervisor");
		idSupervisor.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idSupervisor);

		nombreEmpleado = new JPanelEtiqueta("		nombre empleado");
		nombreEmpleado.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(nombreEmpleado);

		apellidoEmpleado = new JPanelEtiqueta("		apellido empleado");
		apellidoEmpleado.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(apellidoEmpleado);

		email = new JPanelEtiqueta("		email");
		email.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(email);

		telefono = new JPanelEtiqueta("		telefono");
		telefono.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(telefono);

		salario = new JPanelEtiqueta("		salario");
		salario.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(salario);

		fechaContrato = new Fecha("seleccione la fecha", 70, 0);
		fechaContrato.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
		fechaContrato.setPreferredSize(new Dimension(75,20));


		comision = new JPanelEtiqueta("  comision");
		comision.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(comision);

		idtrabajo = new JPanelEtiqueta("  id trabajo");
		idtrabajo.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idtrabajo);

		jPanelButtons = new JPanelButtons(ComandApp.ADD_EMPLEADO.name(), 
				ComandApp.MOSTRAR_EMPLEADO.name(), ComandApp.MODIFICAR_EMPLEADO.name(), 
				ComandApp.ELIMINAR_EMPLEADO.name(),control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		
		gbc.gridx =0;
		gbc.gridy =0;
		gbc.gridheight =0;
		gbc.gridwidth =1;
		this.add(panelContainer);
		
		gbc.gridx =0;
		gbc.gridy =5;
		gbc.gridheight =1;
		gbc.gridwidth =1;
		panelContainerSouth.add(fechaContrato);
		
		gbc.gridx =0;
		gbc.gridy =6;
		gbc.gridheight =1;
		gbc.gridwidth =1;
		panelContainerSouth.add(jPanelButtons);
	
		this.add(panelContainerSouth);
	}

	public int getIdEmpleado() {
		return Integer.parseInt(idEmpleado.getTxtEtiqueta());
	}

	public int getIdDepartamento() {
		return Integer.parseInt(idDepartamento.getTxtEtiqueta());
	}

	public int getidSupervisor() {
		return Integer.parseInt(idSupervisor.getTxtEtiqueta());
	}

	public String getNombreEmpleado() {
		return nombreEmpleado.getTxtEtiqueta();
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado.getTxtEtiqueta();
	}
	
	public String getEmail() {
		return email.getTxtEtiqueta();
	}
	
	public int getTelefono() {
		return Integer.parseInt(telefono.getTxtEtiqueta());
	}
	
	public int getidtrabajo() {
		return Integer.parseInt(idtrabajo.getTxtEtiqueta());
	}

	public Date getFechaContrato() {
		return fechaContrato.getDate();
	}

	public Double getSalario() {
		return Double.parseDouble(salario.getTxtEtiqueta());
	}

	public Double getComision() {
		return Double.parseDouble(comision.getTxtEtiqueta());
	}

}
