package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelLugares extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idUbicacion;
	private JPanelEtiqueta idPais;
	private JPanelEtiqueta direccion;
	private JPanelEtiqueta codigoPostal;
	private JPanelEtiqueta ciudad;
	private JPanelEtiqueta estadoProvincia;
	private JPanelButtons jPanelButtons;

	public JPanelLugares(Controller control) {
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

		idUbicacion = new JPanelEtiqueta("		id ubicacion");
		idUbicacion.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idUbicacion);
		
		idPais = new JPanelEtiqueta("		id pais");
		idPais.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idPais);

		direccion = new JPanelEtiqueta("		direccion");
		direccion.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(direccion);

		codigoPostal = new JPanelEtiqueta("		codigo postal");
		codigoPostal.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(codigoPostal);

		ciudad = new JPanelEtiqueta("		ciudad");
		ciudad.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(ciudad);
		
		estadoProvincia = new JPanelEtiqueta("		Estado Provincia");
		estadoProvincia.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(estadoProvincia);
		
		jPanelButtons = new JPanelButtons(ComandApp.ADD_UBICACION.name(), 
				ComandApp.MOSTRAR_UBICACION.name(), ComandApp.MODIFICAR_UBICACION.name(), 
				ComandApp.ELIMINAR_UBICACION.name(),control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}

	public int getidPais() {
		return Integer.parseInt(idPais.getTxtEtiqueta());
	}

	public String getdireccion() {
		return direccion.getTxtEtiqueta();
	}
	
	public String getciudad() {
		return ciudad.getTxtEtiqueta();
	}

	public String getestadoProvincial() {
		return estadoProvincia.getTxtEtiqueta();
	}
	
	public int getidUbicacion() {
		return Integer.parseInt(idUbicacion.getTxtEtiqueta());
	}

	public int getcodigoPostal() {
		return Integer.getInteger(codigoPostal.getTxtEtiqueta());
	}
}