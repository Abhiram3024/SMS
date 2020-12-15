package student_ms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student_MS extends JFrame{

	private JFrame frame;
	private JTextField ID;
	private JTextField Name;
	private JTextField Mobile;
	private JTextField Branch;
	private JTable table;
	DefaultTableModel model;
	private JTextField Sem;
	private JTextField CGPA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_MS window = new Student_MS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student_MS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, -27, 907, 570);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(23, 81, 74, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 116, 74, 35);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(23, 190, 89, 35);
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblMobileNo);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(23, 231, 74, 35);
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblBranch);
		
		ID = new JTextField();
		ID.setBounds(122, 93, 96, 19);
		panel.add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(122, 128, 96, 19);
		Name.setColumns(10);
		panel.add(Name);
		
		Mobile = new JTextField();
		Mobile.setBounds(122, 202, 96, 19);
		Mobile.setColumns(10);
		panel.add(Mobile);
		
		Branch = new JTextField();
		Branch.setBounds(122, 243, 96, 19);
		Branch.setColumns(10);
		panel.add(Branch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 83, 611, 459);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				ID.setText(model.getValueAt(i, 0).toString());
				Name.setText(model.getValueAt(i, 1).toString());
				Sem.setText(model.getValueAt(i, 2).toString());
				Mobile.setText(model.getValueAt(i, 3).toString());
				Branch.setText(model.getValueAt(i, 4).toString());
				CGPA.setText(model.getValueAt(i, 5).toString());
				
			}
		});
		model= new DefaultTableModel();
		Object[] column = {"ID","Name","Sem","Mobile No","Branch","CGPA"};
		Object[] row=new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(23, 381, 109, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.getText().equals("")|| Name.getText().equals("")||Sem.getText().equals("")|| Mobile.getText().equals("")||Branch.getText().equals("")||CGPA.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please fill complete information.");
				}
				else {
					
				row[0]=ID.getText();
				row[1]=Name.getText();
				row[2]=Sem.getText();
				row[3]=Mobile.getText();
				row[4]=Branch.getText();
				row[5]=CGPA.getText();
				model.addRow(row);
				
				ID.setText("");
				Name.setText("");
				Sem.setText("");
				Mobile.setText("");
				Branch.setText("");
				CGPA.setText("");
				JOptionPane.showMessageDialog(null,"Saved successfully.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(23, 459, 109, 50);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
				model.removeRow(i);
				JOptionPane.showMessageDialog(null,"Deleted successfully.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a row first.");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(154, 381, 109, 50);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
				model.setValueAt(ID.getText(),i,0);
				model.setValueAt(Name.getText(),i,1);
				model.setValueAt(Sem.getText(),i,2);
				model.setValueAt(Mobile.getText(),i,3);
				model.setValueAt(Branch.getText(),i,4);
				model.setValueAt(CGPA.getText(),i,5);
				JOptionPane.showMessageDialog(null,"Updated successfully.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select a row first");
					
				}
				
			}
				
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(154, 459, 109, 50);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ID.setText("");
				Name.setText("");
				Sem.setText("");
				Mobile.setText("");
				Branch.setText("");
				CGPA.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(btnClear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSemester.setBounds(23, 161, 89, 19);
		panel.add(lblSemester);
		
		JLabel lblCGPA = new JLabel("CGPA");
		lblCGPA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCGPA.setBounds(23, 276, 89, 27);
		panel.add(lblCGPA);
		
		Sem = new JTextField();
		Sem.setBounds(122, 165, 96, 19);
		panel.add(Sem);
		Sem.setColumns(10);
		
		CGPA = new JTextField();
		CGPA.setBounds(122, 284, 96, 19);
		panel.add(CGPA);
		CGPA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(176, 33, 380, 50);
		panel.add(lblNewLabel_1);
	}
}
