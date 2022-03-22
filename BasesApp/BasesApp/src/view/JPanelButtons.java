package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import controllers.Controller;

public class JPanelButtons extends JPanel{

	private static final long serialVersionUID = 1L;
	private ConfigButton btnCrear;
	private ConfigButton btnMostrar;
	private ConfigButton btnEliminar;
	private ConfigButton btnModificar;
	
	public JPanelButtons(String comandCrear,String comandMostrar,String comandModificar,String comandEliminar,Controller control) {
		GridLayout layout = new GridLayout(1,4);
		layout.setHgap(7);
		this.setBackground(Color.WHITE);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(140,70));
		initComponents(comandCrear,comandMostrar,comandModificar,comandEliminar,control);
		setVisible(true);
	}
	
	private void initComponents(String comandCrear,String comandMostrar,String comandModificar,String comandEliminar,Controller control) {
		btnCrear= new ConfigButton("Crear", Color.white, Color.black);
		btnCrear.setActionCommand(comandCrear);
		btnCrear.setBorder(new RoundBorder(40));
		btnCrear.setPreferredSize(new Dimension(100,50));
		btnCrear.addActionListener(control);
		this.add(btnCrear);
		
		btnMostrar= new ConfigButton("Mostrar", Color.white, Color.black);
		btnMostrar.setPreferredSize(new Dimension(100,50));
		btnMostrar.setBorder(new RoundBorder(40));
		btnMostrar.setActionCommand(comandMostrar);
		this.add(btnMostrar);
		
		btnModificar= new ConfigButton("Modificar", Color.white, Color.black);
		btnModificar.setActionCommand(comandModificar);
		btnModificar.setBorder(new RoundBorder(40));
		btnModificar.setPreferredSize(new Dimension(100,50));
		this.add(btnModificar);
		
		btnEliminar= new ConfigButton("Eliminar", Color.white, Color.black);
		btnEliminar.setPreferredSize(new Dimension(100,50));
		btnEliminar.setBorder(new RoundBorder(40));
		btnEliminar.setActionCommand(comandEliminar);
		this.add(btnEliminar);
	}
}