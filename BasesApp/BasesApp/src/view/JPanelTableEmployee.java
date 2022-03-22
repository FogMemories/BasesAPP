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
import models.Departament;
import models.Employee;

public class JPanelTableEmployee extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements; 
	private JTable jtElements;
	private JScrollPane jsTable;
	private String[] headers;
	private ArrayList<Employee> list;

	public JPanelTableEmployee(Controller controller) throws SQLException {
		this.list =controller.cargarEmpleados();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.YELLOW);
		setSize( 500, 200 );
		setLocationRelativeTo(null);
		
		setResizable(false);
		setModal(true);
		initComponents();
		this.setVisible(true);
		controller.cargarEmpleados();
	}

	private void initComponents() {

		headers = ConstantsView.headers_empleados;
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

	public void addElementToTable(ArrayList<Employee> list2){
		for (Employee employee : list2) {
			Object [] fila=new Object[10];
			fila[0]=employee.getIdEmployee();
	        fila[1]=employee.getIdDepartament();
	        fila[2]=employee.getIdSupervisor();
	        fila[3]=employee.getNameEmploye();
	        fila[4]=employee.getLastName();
	        fila[5]=employee.getEmail();
	        fila[6]=employee.getPhone();
	        fila[7]=employee.getDateContract();
	        fila[8]=employee.getSalario();
	        fila[9]=employee.getComision();

	        dtmElements.addRow(fila);
		}
		
	}
}