package System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctors extends JFrame implements ActionListener, MouseListener {
    Connection con;
    PreparedStatement stmt;
    DefaultTableModel model;
    DefaultTableModel model1;
    JTable patienttable;
    JTable medicinetable;
    JTextField idtxt;
    JTextField nametxt;
    JTextField medicinetxt;
    JTextField diagnosis;
    JTextField medicinedatetxt;
    JButton addmedicinebtn;
    JButton updatemedicinebtn;
    JButton diagonsisbtn;
    JButton keydatebtn;

    Doctors() {


        Font f = new Font("Serif", Font.BOLD, 50);
        Font f1 = new Font("Serif", Font.BOLD, 30);
        // -----      -------------- header-----------------
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color( 0, 255, 0));
        heading.setBounds(0, 0, 1900, 100);

        JLabel name = new JLabel("Hospital Management System");
        name.setForeground(Color.BLACK);
        name.setBounds(90, 50, 900, 50);
        name.setFont(f);
        heading.add(name);

        JPanel patient = new JPanel();
        patient.setLayout(null);
        patient.setSize(1600, 1200);
        patient.setBackground(new Color(0, 0, 0, 100));
        patient.setBounds(0, 100, 1850, 900);

        JLabel name2 = new JLabel(" ------MY PATIENT DETAILS------");
        name2.setForeground(Color.BLACK);
        name2.setBounds(800, 50, 500, 25);
        name2.setFont(new Font("Verdana", Font.BOLD, 19));
        patient.add(name2);

        JLabel name3 = new JLabel(" -----------Medicine Form ----------");
        name3.setForeground(Color.BLACK);
        name3.setBounds(10, 10, 500, 25);
        name3.setFont(new Font("Verdana", Font.BOLD, 19));
        patient.add(name3);
//        ------------------------------------------------jTEXTFIELD----------------------------------------------------
        JLabel namelbl = new JLabel("Patient Name:");
        namelbl.setBounds(10, 100, 220, 30);
        namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        namelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(namelbl);

        nametxt = new JTextField(" ");
        nametxt.setBounds(190, 100, 220, 30);
        nametxt.setFont(new Font("Verdana", Font.BOLD, 16));
        nametxt.setBackground(new Color(102, 153, 153));
        patient.add(nametxt);

        JLabel medicinelbl = new JLabel("Medicine Name:");
        medicinelbl.setBounds(10, 150, 220, 30);
        medicinelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        medicinelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(medicinelbl);

        medicinetxt = new JTextField(" ");
        medicinetxt.setBounds(190, 150, 220, 30);
        medicinetxt.setFont(new Font("Verdana", Font.BOLD, 16));
        medicinetxt.setBackground(new Color(102, 153, 153));
        patient.add(medicinetxt);

        JLabel medicinedatelbl = new JLabel("Medicine Time:");
        medicinedatelbl.setBounds(10, 200, 220, 30);
        medicinedatelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        medicinedatelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(medicinedatelbl);

        medicinedatetxt = new JTextField(" ");
        medicinedatetxt.setBounds(190, 200, 220, 30);
        medicinedatetxt.setFont(new Font("Verdana", Font.BOLD, 16));
        medicinedatetxt.setBackground(new Color(102, 153, 153));
        patient.add(medicinedatetxt);

        JLabel patientid = new JLabel("Patient ID:");
        patientid.setFont(new Font("Verdana", Font.BOLD, 19));
        patientid.setBounds(10, 50, 130, 30);
        patientid.setBackground(new Color(215, 205, 205, 24));
        patient.add(patientid);

        idtxt = new JTextField(" ");
        idtxt.setBounds(190, 52, 220, 30);
        idtxt.setFont(new Font("Verdana", Font.BOLD, 16));
        idtxt.setBackground(new Color(102, 153, 153));
        patient.add(idtxt);


//        JLabel currentdignosis = new JLabel("Current Diagnosis:");
//        currentdignosis.setFont(new Font("Verdana", Font.BOLD, 16));
//        currentdignosis.setBounds(10, 600, 170, 30);
//        currentdignosis.setBackground(new Color(210, 180, 140));
//        patient.add(currentdignosis);
//
//        diagnosis = new JTextField("");
//        diagnosis.setFont(new Font("Verdana", Font.BOLD, 14));
//        diagnosis.setBounds(190, 583, 220, 67);
//        diagnosis.setBackground(new Color(102, 153, 153));
//        patient.add(diagnosis);
    
//        ---------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------JTable----------------------------------------------------------------------
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(500, 91, 1000, 445);
        patient.add(scrollPane);

        model = new DefaultTableModel();
        patienttable = new JTable();
        Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender", "Age", "Blood Group", "Doctor Assigned", "Address", "Symptoms", "Date"};
        Object[] row = new Object[0];
        scrollPane.setViewportView(patienttable);
        model.setColumnIdentifiers(column);
        patienttable.setModel(model);
        patienttable.addMouseListener(this);

        JScrollPane scrollPanell = new JScrollPane();
        scrollPanell.setBounds(10, 351, 400, 145);
        patient.add(scrollPanell);

        model1 = new DefaultTableModel();
        medicinetable = new JTable();
        Object[] columnn = {"Patient ID", "Patient Name", "Medicine Name", "Medicine Time"};
        Object[] roww = new Object[0];
        scrollPanell.setViewportView(medicinetable);
        model1.setColumnIdentifiers(columnn);
        medicinetable.setModel(model1);

//        _____________________________________________Buttons_____________________________________________________________
        diagonsisbtn = new JButton("Add Diagnosis");
		diagonsisbtn.setBounds(80, 525, 200, 55);
		patient.add(diagonsisbtn);
		diagonsisbtn.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  AddDaignosis add = new AddDaignosis();
	        
	        }
		});
	        keydatebtn = new JButton("Add Key Date");
			keydatebtn.setBounds(230, 525, 200, 55);
			patient.add(keydatebtn);
			keydatebtn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  KeyDates add = new KeyDates();
		        
		        }
			});
        
        
        
        addmedicinebtn = new JButton("Add Medicine");
        addmedicinebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id,patientname, medicinename, medicinetimes;
                con = DbConnect.Connect();
                id= idtxt.getText();
                patientname = nametxt.getText();
                medicinename = medicinetxt.getText();
                medicinetimes = medicinedatetxt.getText();


                try {
                    String query = "insert into medicinetable(id,patientname,medicinename,medicinetime) values(?,?,?,?)";
                    stmt = con.prepareStatement(query);
                    stmt.setString(1, id);
                    stmt.setString(2, patientname);
                    stmt.setString(3, medicinename);
                    stmt.setString(4, medicinetimes);
                    stmt.execute();

                    JOptionPane.showMessageDialog(addmedicinebtn, "Medicine admitted successfully!");
                    medicinetable_remove();
                    table_load1();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        addmedicinebtn.setBounds(10, 272, 186, 47);
        addmedicinebtn.setFont(new Font("Verdana", Font.BOLD, 14));
        addmedicinebtn.setBackground(new Color(255, 153, 0));
        patient.add(addmedicinebtn);

        updatemedicinebtn = new JButton("Update Medicine");
        updatemedicinebtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        updatemedicinebtn.setBounds(225, 272, 186, 47);
        updatemedicinebtn.setFont(new Font("Verdana", Font.BOLD, 14));
        updatemedicinebtn.setBackground(new Color(170, 242, 0));
        patient.add(updatemedicinebtn);


        JLabel name1 = new JLabel(" Welcome Doctor Panel");
        name1.setForeground(Color.BLACK);
        name1.setBounds(795, 10, 500, 25);
        name1.setFont(f1);
        patient.add(name1);


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
    public void  medicinetable_remove() {
        for (int i = model1.getRowCount() - 1; i >= 0; i--) {
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
            String query = "select * from medicinetable";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String id = result.getString("id");
                String patientname= result.getString("patientname");
                String medicinename = result.getString("medicinename");
                String medicinetime= result.getString("medicinetime");




                model1.addRow(new Object[] {id,patientname,medicinename,medicinetime});
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }



    public static void main(String args[]){
        new Doctors();}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = patienttable.rowAtPoint(e.getPoint());
        idtxt.setText((String)model.getValueAt(row,0));


        nametxt.setText((String) model.getValueAt(row,1));

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
