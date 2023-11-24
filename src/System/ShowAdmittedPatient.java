package System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAdmittedPatient extends JFrame implements ActionListener, MouseListener {

	private JPanel admittedpatient;
	Connection con;
	PreparedStatement stmt;
	DefaultTableModel model;
	DefaultTableModel model1;
	JTextField idtxt;
	JTextField nametxt;
	JTextField admittedtxt;
	JTable newadmittedtable;
	JTable admittedpatienttable;
	JButton addpatientbtn;
	JButton updatepatientbtn;
	JButton resetpatientbtn;
	ShowAdmittedPatient() {


		Font f = new Font("Serif", Font.BOLD, 50);
		Font f1 = new Font("Serif", Font.BOLD, 30);
		// -----      -------------- header-----------------
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(45, 70, 29, 255));
		heading.setBounds(0, 0, 1900, 100);

		JLabel name = new JLabel("Hospital Management System");
		name.setForeground(Color.BLACK);
		name.setBounds(0, 20, 900, 50);
		name.setFont(f);
		heading.add(name);
//----------------------------------------------pannel------------------------------------------------------
		JPanel patient = new JPanel();
		patient.setLayout(null);
		patient.setSize(1600, 1200);
		patient.setBackground(new Color(0, 0, 0, 100));
		patient.setBounds(0, 100, 1850, 900);

		JLabel namelbl = new JLabel("Patient Name:");
		namelbl.setBounds(10, 190, 220, 30);
		namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
		namelbl.setBackground(new Color(215, 205, 205, 24));
		patient.add(namelbl);

		nametxt = new JTextField(" ");
		nametxt.setBounds(190, 190, 220, 30);
		nametxt.setFont(new Font("Verdana", Font.BOLD, 16));
		nametxt.setBackground(new Color(210, 180, 160));
		patient.add(nametxt);


		JLabel patientid1 = new JLabel("Patient ID:");
		patientid1.setFont(new Font("Verdana", Font.BOLD, 19));
		patientid1.setBounds(10, 140, 130, 30);
		patientid1.setBackground(new Color(215, 205, 205, 24));
		patient.add(patientid1);

		idtxt = new JTextField(" ");
		idtxt.setBounds(190, 140, 220, 30);
		idtxt.setFont(new Font("Verdana", Font.BOLD, 16));
		idtxt.setBackground(new Color(210, 180, 160));
		patient.add(idtxt);


		JLabel wardnum = new JLabel("Ward :");
		wardnum.setFont(new Font("Verdana", Font.BOLD, 19));
		wardnum.setBounds(10, 250, 120, 30);
		wardnum.setBackground(new Color(210, 180, 140));
		patient.add(wardnum);

		String[] ward_type = {"General", "pediatrics", "Maternity", "Geriatrics", "psychiatric", "ICU"};
		JComboBox comboBoxward = new JComboBox(ward_type);
		comboBoxward.setFont(new Font("Verdana", Font.BOLD, 16));
		comboBoxward.setBounds(190, 250, 220, 30);
		patient.add(comboBoxward);

		JLabel bed_lbl = new JLabel("Bed Num:");
		bed_lbl.setFont(new Font("Verdana", Font.BOLD, 19));
		bed_lbl.setBounds(10, 300, 120, 30);
		bed_lbl.setBackground(new Color(210, 180, 140));
		patient.add(bed_lbl);

		String[] bed_type = {"A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4"};
		JComboBox comboBoxbed = new JComboBox(bed_type);
		comboBoxbed.setFont(new Font("Verdana", Font.BOLD, 14));
		comboBoxbed.setBounds(190, 300, 220, 30);
		patient.add(comboBoxbed);

//

		JLabel doctor_lbl = new JLabel("Doctor:");
		doctor_lbl.setFont(new Font("Verdana", Font.BOLD, 19));
		doctor_lbl.setBounds(10, 350, 100, 30);
		doctor_lbl.setBackground(new Color(210, 180, 140));
		patient.add(doctor_lbl);

		String[] doctor_type = {"Dr.Ashis(Neuro Surgen)", "Dr.Bibek(Cardio)", "Dr.Ram(Mbbs,MD)", "Dr.shyam(Radiologist)"};
		JComboBox comboBoxdoctor = new JComboBox(doctor_type);
		comboBoxdoctor.setFont(new Font("Verdana", Font.BOLD, 14));
		comboBoxdoctor.setBounds(190, 350, 220, 30);
		patient.add(comboBoxdoctor);

		JLabel nurse_lbl = new JLabel("Nurse:");
		nurse_lbl.setFont(new Font("Verdana", Font.BOLD, 19));
		nurse_lbl.setBounds(10, 410, 100, 30);
		nurse_lbl.setBackground(new Color(210, 180, 140));
		patient.add(nurse_lbl);

		String[] nurse_type = {"Sita", "Gita", "Muna", "Anita"};
		JComboBox comboBoxnurse = new JComboBox(nurse_type);
		comboBoxnurse.setFont(new Font("Verdana", Font.BOLD, 14));
		comboBoxnurse.setBounds(190, 410, 220, 30);
		patient.add(comboBoxnurse);

		JLabel admitteddate = new JLabel(" Admitted Date:");
		admitteddate.setFont(new Font("Verdana", Font.BOLD, 29));
		admitteddate.setBounds(10, 460, 140, 30);
		admitteddate.setBackground(new Color(210, 180, 140));
		patient.add(admitteddate);

		admittedtxt = new JTextField(" ");
		admittedtxt.setBounds(190, 460, 220, 30);
		admitteddate.setFont(new Font("Verdana", Font.BOLD, 16));
		admittedtxt.setBackground(new Color(210, 180, 160));
		patient.add(admittedtxt);
//		--------------------------------------------buttons----------------------------------------


		addpatientbtn = new JButton("Add Patient");
		addpatientbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,patientname, ward, bednum, doctor, nurse, date;
				con = DbConnect.Connect();
				id = idtxt.getText();
				patientname = nametxt.getText();
				ward = String.valueOf(comboBoxward.getSelectedItem());
				bednum = String.valueOf(comboBoxbed.getSelectedItem());
				doctor = String.valueOf(comboBoxdoctor.getSelectedItem());
				nurse = String.valueOf(comboBoxnurse.getSelectedItem());
				date = admittedtxt.getText();


				try {
					String query = "insert into admittable(id,patientname,wardno,bednum,doctor,nurse,admitteddate) values(?,?,?,?,?,?,?)";
					stmt = con.prepareStatement(query);
					stmt.setString(1, id);
					stmt.setString(2, patientname);
					stmt.setString(3, ward);
					stmt.setString(4, bednum);
					stmt.setString(5, doctor);

					stmt.setString(6, nurse);
					stmt.setString(7, date);
					stmt.execute();

					JOptionPane.showMessageDialog(addpatientbtn, "Patient admitted successfully!");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


		addpatientbtn.setBounds(0, 540, 160, 60);
		addpatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
		addpatientbtn.setBackground(new Color(160, 182, 45));
		patient.add(addpatientbtn);

		updatepatientbtn = new JButton("Update Patient");
		updatepatientbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, patientname, ward, bednum, doctor, nurse, date;
				con = DbConnect.Connect();
				//Integer patientid2=Integer.parseInt(patientid1.getText());
				System.out.println(patientid1.getText());
				id = idtxt.getText();
				patientname = nametxt.getText();
				ward = String.valueOf(comboBoxward.getSelectedItem());
				bednum = String.valueOf(comboBoxbed.getSelectedItem());
				doctor = String.valueOf(comboBoxdoctor.getSelectedItem());
				nurse = String.valueOf(comboBoxnurse.getSelectedItem());
				date = admittedtxt.getText();
				//System.out.println(patientid2);


				try {
//                String query = "insert into patient(patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date) values(?,?,?,?,?,?,?,?,?,?)";
					stmt = con.prepareStatement("update admittable set patientname=?,wardno=?,bednum=?,doctor=?,nurse=?,admitteddate=? where id=?");
//					String query = "insert into admittable(patientname,wardno,bednum,doctor,nurse,admitteddate) values(?,?,?,?,?,?)";

					stmt.setString(1, patientname);
					stmt.setString(2, ward);
					stmt.setString(3, bednum);
					stmt.setString(4, doctor);

					stmt.setString(5, nurse);
					stmt.setString(6, date);
					stmt.setString(7, id);
					stmt.execute();

					JOptionPane.showMessageDialog(updatepatientbtn, "Patient updated successfully!");

 				    newadmittedtable_remove();
					table_load1();


					idtxt.setText("");
					nametxt.setText("");

					admittedtxt.setText("");


				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});


		updatepatientbtn.setBounds(170, 540, 160, 60);
		updatepatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
		updatepatientbtn.setBackground(new Color(45, 182, 139));
		patient.add(updatepatientbtn);

		resetpatientbtn = new JButton("Reset Patient");
		resetpatientbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtxt.setText("");
				nametxt.setText("");
				admittedtxt.setText("");
			}
		});
		resetpatientbtn.setBounds(350, 540, 160, 60);
		resetpatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
		resetpatientbtn.setBackground(new Color(45, 182, 139));
		patient.add(resetpatientbtn);


//		------------------------------------------JTABLE-----------------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 81, 950, 345);
		patient.add(scrollPane);
		model = new DefaultTableModel();
		admittedpatienttable = new JTable();
		Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender", "Age", "Blood Group", "Address", "Symptoms", "Doctor Assigned", "Date"};
		Object[] row = new Object[0];
		scrollPane.setViewportView(admittedpatienttable);
		model.setColumnIdentifiers(column);
		admittedpatienttable.setModel(model);
		admittedpatienttable.addMouseListener(this);

		JScrollPane scrollPanell = new JScrollPane();
		scrollPanell.setBounds(530, 499, 950, 150);
		patient.add(scrollPanell);

		model1 = new DefaultTableModel();
		newadmittedtable = new JTable();
		Object[] columnn = {"Patient ID", "Patient Name", "Ward Num", "Bed Num", "Doctor", "Nurse", "Admitted Date"};
		Object[] row1 = new Object[0];
		scrollPanell.setViewportView(newadmittedtable);
		model1.setColumnIdentifiers(columnn);
		newadmittedtable.setModel(model1);
//_______________________________________________________________________________________________________________________________________


		JLabel name1 = new JLabel(" ADMITTED PATIENT DETAILS");
		name1.setForeground(Color.BLACK);
		name1.setBounds(780, 10, 500, 25);
		name1.setFont(f1);
		patient.add(name1);

		JLabel name2 = new JLabel(" MY PATIENT DETAILS");
		name2.setForeground(Color.BLACK);
		name2.setBounds(880, 50, 500, 25);
		name2.setFont(new Font("Verdana", Font.BOLD, 19));
		patient.add(name2);

		JLabel name3 = new JLabel(" ADMIT PATIENT Field");
		name3.setForeground(Color.BLACK);
		name3.setBounds(60, 40, 500, 25);
		name3.setFont(new Font("Verdana", Font.BOLD, 19));
		patient.add(name3);

		JLabel name4 = new JLabel(" Admitted Patient Details ");
		name4.setForeground(Color.BLACK);
		name4.setBounds(880, 440, 500, 25);
		name4.setFont(new Font("Verdana", Font.BOLD, 19));
		patient.add(name4);


		ImageIcon background_img = new ImageIcon("hos.jpg");
		Image img1 = background_img.getImage();
		Image temp_img = img1.getScaledInstance(2000, 600, Image.SCALE_SMOOTH);
		background_img = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_img, JLabel.CENTER);
		background.add(patient);

		background.add(heading);
		background.setBounds(0, 0, 2000, 1000);
		getContentPane().add(background);


		setSize(2000, 1200);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		table_load();
		table_load1();
	}
	public void  newadmittedtable_remove() {
		for (int i= model1.getRowCount()-1; i >=0; i--){
			model1.removeRow(i);
		}



	}
	public void table_load(){
		try {
			con = DbConnect.Connect();
			String query = "select * from patient";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				String id = result.getString("id");
				String patient_name = result.getString("patient_name");
				String dob= result.getString("dob");
				String  contact= result.getString("contact");
				String  age= result.getString("age");
				String gender = result.getString("gender");
				String  bloodgroup= result.getString("bloodgroup");
				String doctor = result.getString("doctor");
				String address = result.getString("address");
				String  symptoms= result.getString("symptoms");
				String date = result.getString("date");

				model.addRow(new Object[] {id,patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date});
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}

	public void table_load1(){
		try {
			con = DbConnect.Connect();
			String query = "select * from admittable";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				String id = result.getString("id");
				String patient_name = result.getString("patientname");
				String wardno= result.getString("wardno");
				String  bednum= result.getString("bednum");
				String  doctor= result.getString("doctor");
				String nurse = result.getString("nurse");

				String date = result.getString("admitteddate");

				model1.addRow(new Object[] {id,patient_name,wardno,bednum,doctor,nurse,date});
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}






	public static void main(String args[]){
		new ShowAdmittedPatient();}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = admittedpatienttable.rowAtPoint(e.getPoint());
		idtxt.setText((String) model.getValueAt(row,0));
		nametxt.setText((String) model.getValueAt(row,1));
//


	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
