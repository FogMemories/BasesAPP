package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelPaises extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta idPais;
	private JPanelEtiqueta idRegion;
	private JPanelEtiqueta nombrePais;
	private JPanelButtons jPanelButtons;

	public JPanelPaises(Controller control) {
		setSize( 500, 450);
		this.setBackground(Color.WHITE);
		initComponents(control);
		setVisible(true);
	}

	private void initComponents(Controller control) {
		JPanel panelContainer = new JPanel();
		GridLayout layout = new GridLayout(4,1);
		panelContainer.setBackground(Color.WHITE);
		panelContainer.setBorder(new RoundBorder(50));
		panelContainer.setLayout(layout);
		panelContainer.setSize( 500, 300 );
		panelContainer.	setVisible(true);

		idPais = new JPanelEtiqueta("		id pais");
		idPais.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idPais);

		idRegion = new JPanelEtiqueta("		id region");
		idRegion.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(idRegion);

		nombrePais = new JPanelEtiqueta("		nombre pais");
		nombrePais.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(nombrePais);

		jPanelButtons = new JPanelButtons(ComandApp.ADD_PAIS.name(), 
				ComandApp.MOSTRAR_PAIS.name(), ComandApp.MODIFICAR_PAIS.name(), 
				ComandApp.ELIMINAR_PAIS.name(), control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}
	
	public int getIdPais() {
		return Integer.parseInt(idPais.getTxtEtiqueta());
	}

	public int getIdRegion() {
		return Integer.parseInt(idRegion.getTxtEtiqueta());
	}

	public String getNombrePais() {
		return nombrePais.getTxtEtiqueta();
	}
}