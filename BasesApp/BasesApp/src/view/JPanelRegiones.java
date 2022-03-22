package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import controllers.ComandApp;
import controllers.Controller;

public class JPanelRegiones extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelEtiqueta nombreRegion;
	private JPanelButtons jPanelButtons;

	public JPanelRegiones(Controller control) {
		setSize( 500, 300 );
		this.setBackground(Color.WHITE);
		initComponents(control);
		setVisible(true);
	}

	private void initComponents(Controller control) {
		JPanel panelContainer = new JPanel();
		GridLayout layout = new GridLayout(2,1);
		panelContainer.setBackground(Color.WHITE);
		panelContainer.setBorder(new RoundBorder(50));
		panelContainer.setLayout(layout);
		panelContainer.setSize( 500, 300 );
		panelContainer.	setVisible(true);
		
		nombreRegion = new JPanelEtiqueta("		nombre region");
		nombreRegion.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
		panelContainer.add(nombreRegion);

		jPanelButtons = new JPanelButtons(ComandApp.ADD_REGION.name(), 
				ComandApp.MOSTRAR_REGION.name(), ComandApp.MODIFICAR_REGION.name(), 
				ComandApp.ELIMINAR_REGION.name(), control);
		jPanelButtons.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		panelContainer.add(jPanelButtons);
		this.add(panelContainer);
	}
	
	public String getNombreRegion() {
		return nombreRegion.getTxtEtiqueta();
	}
	
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion.setLblEtiqueta(nombreRegion);
	}
}