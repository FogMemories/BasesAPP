package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.ConstantsView;
import controllers.Controller;
import models.Region;
import models.Work;

public class JPanelTableRegiones extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements; 
	private JTable jtElements;
	private JScrollPane jsTable;
	private String[] headers;
	private ArrayList<Region> list;
	public JPanelTableRegiones(Controller controller) throws SQLException {
		
		this.list=controller.cargarRegiones();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.YELLOW);
		setSize( 350, 200 );

		this.setVisible(true);
		setResizable(false);
		setModal(true);
		initComponents();
		setVisible(true);
	}

	

	private void initComponents() {

		headers = ConstantsView.headers_regiones;
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(headers);

		Font fontTable = new Font("Franklin Gothic Demi", Font.ITALIC, 14);

		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setBackground(Color.YELLOW);
		jtElements.getTableHeader().setForeground(Color.BLACK);
		jtElements.getTableHeader().setFont(fontTable);

		jtElements.setFillsViewportHeight(true);
		jtElements.setBorder(null);
		jtElements.setEnabled(true);

		jsTable = new JScrollPane(jtElements);
		jsTable.setForeground(Color.BLACK);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(jsTable);
		addElementToTable(this.list);
	}
	
	public void addElementToTable(ArrayList<Region> list2){
		for (Region region : list2) {
			Object [] fila=new Object[2];
			fila[0]=region.getIdRegion();
	        fila[1]=region.getNombreRegion();

	        dtmElements.addRow(fila);
		}
		
	}
	public JScrollPane getJsTable() {
		return jsTable;
	}
	public void addElementToTable(Object[] vector){
		dtmElements.addRow(vector);
	}
	
	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}
	
	public JTable getJtElements() {
		return jtElements;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
}