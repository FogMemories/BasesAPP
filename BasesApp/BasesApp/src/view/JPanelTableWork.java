package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.ConstantsView;
import controllers.Controller;
import models.Work;

public class JPanelTableWork extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements; 
	private JTable jtElements;
	private JScrollPane jsTable;
	private String[] headers;
	private ArrayList<Work> list;

	public JPanelTableWork(Controller controller) throws SQLException {
		this.list=controller.cargarTrabajos();
		System.err.println("ingreso menu JPanelTableWork");
		this.setLayout(new BorderLayout());
		this.setBackground(Color.YELLOW);
		setSize( 500, 200 );
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		initComponents();
		this.setVisible(true);
	}

	
	private void initComponents() {

		headers = ConstantsView.headers_trabajos;
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

	public void addElementToTable(ArrayList<Work> list2){
		for (Work work : list2) {
			Object [] fila=new Object[4];
			fila[0]=work.getIdTrabajo();
	        fila[1]=work.getTituloTrabajo();
	        fila[2]=work.getSalarioMinimo();
	        fila[3]=work.getSalarioM();
	        dtmElements.addRow(fila);
		}
		
	}
}