package System;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Nurse extends JFrame {
    Connection con;
    PreparedStatement stmt;
    DefaultTableModel model;

    JTable patienttable;
    Nurse()
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

        JLabel name1 = new JLabel(" Welcome to Nurse Panel ");
        name1.setForeground(Color.BLACK);
        name1.setBounds(650,10,500,25);
        name1.setFont(f1);
        patient.add(name1);

        JLabel patientdetails = new JLabel("Patient Details");
        patientdetails.setForeground(Color.BLACK);
        patientdetails.setBounds(695,45,500,25);
        patientdetails.setFont(f1);
        patient.add(patientdetails);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 91, 1470, 550);
        patient.add(scrollPane);

        model = new DefaultTableModel();
        patienttable  = new JTable();
        Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender","Age", "Blood Group", "Doctor Assigned","Address","Symptoms", "Date"};
        Object[] row = new Object[0];
        scrollPane.setViewportView(patienttable);
        model.setColumnIdentifiers(column);
        patienttable.setModel(model);





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
    public static void main(String args[]){
        new Nurse();}
}
