package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.ConstantsView;

public class JPanelTableHistoryWork extends JDialog{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements; 
	private JTable jtElements;
	private JScrollPane jsTable;
	private String[] headers;

	public JPanelTableHistoryWork() {
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

		headers = ConstantsView.headers_historias_trabajos;
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
	}

	public void addElementToTable(Object[] vector){
		dtmElements.addRow(vector);
	}
}