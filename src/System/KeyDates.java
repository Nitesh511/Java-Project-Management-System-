package System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KeyDates extends JFrame implements ActionListener, MouseListener {
    Connection con;
    PreparedStatement stmt;
    DefaultTableModel model;
    DefaultTableModel model1;
    JTable patienttable;
    JTable keytable;
    JButton backbtn;
    JTextField nametxt;
    JTextField patientidtxt;
    JTextField patientnametxt;
    JTextField idtxt;
    JTextField treatmenttxt;
    JTextField treatmentdatetxt;
    JButton addmedicinebtn;
    JButton updatepatientbtn;
    KeyDates()
    {
        // ------------------font---------------------
        Font f= new Font("Serif",Font.BOLD,50);
        Font f1= new Font("Serif",Font.BOLD,30);
        // -----      -------------- header-----------------
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(45, 70, 29, 255));
        heading.setBounds(0,0,1900,100);

        JLabel name = new JLabel("Hospital Management System");
        name.setForeground(Color.BLACK);
        name.setBounds(130,20,900,50);
        name.setFont(f);
        heading.add(name);

        JPanel patient = new JPanel();
        patient.setLayout(null);
        patient.setSize(1600,1200);
        patient.setBackground(new Color(0,0,0,100));
        patient.setBounds(30,120,1850,900);

        JLabel name1 = new JLabel(" Assign Key Dates !!");
        name1.setForeground(Color.BLACK);
        name1.setBounds(725,300,500,45);
        name1.setFont(f1);
        patient.add(name1);

        JLabel patientdetails = new JLabel("Patient Details   !!!!!!!!!!!");
        patientdetails.setForeground(Color.BLACK);
        patientdetails.setBounds(725,25,500,25);
        patientdetails.setFont(f1);
        patient.add(patientdetails);

        JLabel  patientid  = new JLabel("Patient ID:");
        patientid.setFont(new Font("Verdana", Font.BOLD, 19));
        patientid.setBounds(10,200,130,30);
        patientid.setBackground(new Color(215, 205, 205, 24));
        patient.add(patientid);

        patientidtxt= new JTextField(" ");
        patientidtxt.setBounds(250,202,220,30);
        patientidtxt.setFont(new Font("Verdana", Font.BOLD, 16));
        patientidtxt.setBackground(new Color(210,180,160));
        patient.add(patientidtxt);

        JLabel namelbl = new JLabel("Patient Name:");
        namelbl.setBounds(10,50,220,30);
        namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        namelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(namelbl);

        patientnametxt= new JTextField(" ");
        patientnametxt.setBounds(250,50,220,30);
        patientnametxt.setFont(new Font("Verdana", Font.BOLD, 16));
        patientnametxt.setBackground(new Color(210,180,160));
        patient.add(patientnametxt);


        JLabel treatmentdate   = new JLabel("Treatment Date:");
        treatmentdate.setFont(new Font("Verdana", Font.BOLD, 19));
        treatmentdate.setBounds(10,100,220,30);
        treatmentdate.setBackground(new Color(215, 205, 205, 24));
        patient.add(treatmentdate);

        treatmentdatetxt= new JTextField("");
        treatmentdatetxt.setBounds(250,102,220,30);
        treatmentdatetxt.setFont(new Font("Verdana", Font.BOLD, 16));
        treatmentdatetxt.setBackground(new Color(210,180,160));
        patient.add(treatmentdatetxt);

        JLabel treatmentlbl = new JLabel("Treatment:");
        treatmentlbl.setFont(new Font("Verdana", Font.BOLD, 19));
        treatmentlbl.setBounds(10,150,140,30);
        treatmentlbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(treatmentlbl);

        treatmenttxt= new JTextField(" ");
        treatmenttxt.setBounds(250,150,220,30);
        treatmenttxt.setFont(new Font("Verdana", Font.BOLD, 16));
        treatmenttxt.setBackground(new Color(210,180,160));
        patient.add(treatmenttxt);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(500, 61, 700, 245);
        patient.add(scrollPane);
        model = new DefaultTableModel();
        patienttable  = new JTable();
        Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender","Age", "Blood Group", "Doctor Assigned","Address","Symptoms", "Date"};
        Object[] row = new Object[0];
        scrollPane.setViewportView(patienttable);
        model.setColumnIdentifiers(column);
        patienttable.setModel(model);


        JScrollPane scrollPanell = new JScrollPane();
        scrollPanell.setBounds(500, 350, 700, 200);
        patient.add(scrollPanell);
        model1 = new DefaultTableModel();
        keytable = new JTable();
        Object[] columnn = {"Patient ID", "Patient Name", "Treatment date", "Treatment Time"};
        Object[] roww = new Object[0];
        scrollPanell.setViewportView(keytable);
        model1.setColumnIdentifiers(columnn);
        keytable.setModel(model1);
        keytable.addMouseListener(this);

        addmedicinebtn = new JButton("Add Key Dates");
        addmedicinebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id,patientname, treatmentdate, treatment;
                con = DbConnect.Connect();
                id = patientidtxt.getText();
                patientname = patientnametxt.getText();
                treatmentdate = treatmentdatetxt.getText();
                treatment = treatmenttxt.getText();


                try {
                    String query = "insert into keydate(id,patientname,treatmentdate,treatmenttime) values(?,?,?,?)";
                    stmt = con.prepareStatement(query);
                    stmt.setString(1, id);
                    stmt.setString(2, patientname);
                    stmt.setString(3, treatmentdate);
                    stmt.setString(4, treatment);
                    stmt.execute();

                    JOptionPane.showMessageDialog(addmedicinebtn, "Treatment date added successfully!");

                    medicinetable_remove();
                    table_load1();
                    patientidtxt.setText("");
                    treatmenttxt.setText("");
                    patientnametxt.setText("");
                    treatmenttxt.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        addmedicinebtn.setBounds(100, 272, 250, 47);
        addmedicinebtn.setFont(new Font("Verdana", Font.BOLD, 14));
        addmedicinebtn.setBackground(new Color(160, 182, 45));
        patient.add(addmedicinebtn);

        backbtn = new JButton("DashBoard");


        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                Doctors a = new Doctors();
            }
        });
        backbtn.setBounds(100, 430, 250, 47);
        backbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        backbtn.setBackground(new Color(160, 182, 45));
        patient.add(backbtn);

        updatepatientbtn = new JButton("Update key Dates");
        updatepatientbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id,patientname,treatmentdate,treatment;
                con = DbConnect.Connect();
                id= patientidtxt.getText();
                patientname = patientnametxt.getText();
                treatmentdate = treatmentdatetxt.getText();
                treatment = treatmenttxt.getText();


                try {
//                String query = "insert into patient(patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date) values(?,?,?,?,?,?,?,?,?,?)";
                    stmt = con.prepareStatement("update keydate set patientname=?,treatmentdate=?,treatmenttime=? where id=?");
                    stmt.setString(1,patientname);
                    stmt.setString(2,treatmentdate);
                    stmt.setString(3,treatment);
                    stmt.setString(4,id);
                    stmt.execute();

                    JOptionPane.showMessageDialog(updatepatientbtn,"Keydate updated successfully!");
                    medicinetable_remove();
                    table_load1();

                    patientidtxt.setText("");
                    treatmenttxt.setText("");
                    patientnametxt.setText("");
                    treatmentdatetxt.setText("");
//



                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        updatepatientbtn.setBounds(100,350,250,55);
        updatepatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        updatepatientbtn.setBackground(new Color(45, 182, 139));
        patient.add(updatepatientbtn);





        ImageIcon background_img= new ImageIcon("hos.jpg");
        Image img1 = background_img.getImage();
        Image temp_img= img1.getScaledInstance(2000,600,Image.SCALE_SMOOTH);
        background_img=new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.add(patient);

        background.add(heading);
        background.setBounds(0,0,2000,1000);
        add(background);
        setSize(2000,1200);
        setLayout(null);
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
            String query = "select * from keydate";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String patientid = result.getString("id");
                String patientname= result.getString("patientname");
                String treatmentdate= result.getString("treatmentdate");
                String treatment= result.getString("treatmenttime");
                model1.addRow(new Object[] {patientid,patientname,treatmentdate,treatment});
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]){
        new KeyDates();}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = keytable.rowAtPoint(e.getPoint());
        patientidtxt.setText((String) model.getValueAt(row,0));
        patientnametxt.setText((String) model.getValueAt(row,1));
        treatmentdatetxt.setText((String) model.getValueAt(row,2));
        treatmenttxt.setText((String) model.getValueAt(row,3));


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


