package System;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

class Admins extends JFrame implements ActionListener, MouseListener
{
    Connection con;
    PreparedStatement stmt;
    DefaultTableModel model;
    JTable patienttable;
    JButton updatepatientbtn;
    JButton sortbtn;
    JButton resetpatientbtn;
    JButton showadmittedpatientbtn;
    JTextField idtxt;
    JTextField nametxt;
    JTextField dobtxt;
    JTextField contacttxt;
    JTextField agetxt;
    JTextField address_txt;
    JTextField symptomstxt;
    JTextField admittedtxt;
    JComboBox comboBoxsort;
    ArrayList<Vector<String>> dataArray;
    String[][] data;
 

    Admins()


    {
        // ------------------font---------------------
        Font f= new Font("Serif",Font.BOLD,50);
        Font f1= new Font("Serif",Font.BOLD,30);
// -----      -------------- header-----------------
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color( 51, 102, 153,100));
        heading.setBounds(0,0,1900,100);

        JLabel name = new JLabel("Hospital Management System");
        name.setForeground(Color.BLACK);
        name.setBounds(130,20,900,50);
        name.setFont(f);
        heading.add(name);
//        -------------------------add frame-----------------

        JButton addpatientbtn;
        


        JPanel patient = new JPanel();
        patient.setLayout(null);
        patient.setSize(1600,1200);
        patient.setBackground(new Color(51, 102, 153,100));
        patient.setBounds(0,90,1850,900);

        JLabel name1 = new JLabel("ADMIN DASHBOARD");
        name1.setForeground(Color.BLACK);
        name1.setBounds(700,10,500,25);
        name1.setFont(f1);
        patient.add(name1);

        JLabel namelbl = new JLabel("Patient Name:");
        namelbl.setBounds(10,100,220,30);
        namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        namelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(namelbl);

        nametxt= new JTextField(" ");
        nametxt.setBounds(190,100,220,30);
        nametxt.setFont(new Font("Verdana", Font.BOLD, 16));
        nametxt.setBackground(new Color(102, 153, 153));
        patient.add(nametxt);


        JLabel  patientid  = new JLabel("Patient ID:");
        patientid.setFont(new Font("Verdana", Font.BOLD, 19));
        patientid.setBounds(10,50,130,30);
        patientid.setBackground(new Color(215, 205, 205, 24));
        patient.add(patientid);

        idtxt= new JTextField(" ");
        idtxt.setBounds(190,52,220,30);
        idtxt.setFont(new Font("Verdana", Font.BOLD, 16));
        idtxt.setBackground(new Color(102, 153, 153));
        patient.add(idtxt);

        JLabel doblbl = new JLabel("DOB:");
        doblbl.setFont(new Font("Verdana", Font.BOLD, 19));
        doblbl.setBounds(10,150,100,30);
        doblbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(doblbl);

        dobtxt= new JTextField(" ");
        dobtxt.setBounds(190,150,220,30);
        dobtxt.setFont(new Font("Verdana", Font.BOLD, 16));
        dobtxt.setBackground(new Color(102, 153, 153));
        patient.add(dobtxt);

        JLabel contactlbl = new JLabel("Contact:");
        contactlbl.setFont(new Font("Verdana", Font.BOLD, 19));
        contactlbl.setBounds(10,200,100,30);
        contactlbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(contactlbl);

        contacttxt= new JTextField(" ");
        contacttxt.setBounds(190,200,220,30);
        contacttxt.setFont(new Font("Verdana", Font.BOLD, 16));
        contacttxt.setBackground(new Color(102, 153, 153));
        patient.add(contacttxt);

        JLabel agelbl = new JLabel("Age:");
        agelbl.setFont(new Font("Verdana", Font.BOLD, 19));
        agelbl.setBounds(10,250,100,30);
        agelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(agelbl);

        agetxt= new JTextField(" ");
        agetxt.setBounds(190,250,220,30);
        agetxt.setFont(new Font("Verdana", Font.BOLD, 16));
        agetxt.setBackground(new Color(102, 153, 153));
        patient.add(agetxt);

        JLabel  gender_lbl = new JLabel("Gender:");
        gender_lbl.setFont(new Font("Verdana",Font.BOLD, 19));
        gender_lbl.setBounds(10,300,100,30);
        gender_lbl.setBackground(new Color(210,180,140));
        patient.add(gender_lbl);

        String[] gender_type = {"Male","Female"};
        JComboBox comboBoxgender= new JComboBox(gender_type) ;
        comboBoxgender.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBoxgender.setBounds(190,300,220,30);
        patient.add(comboBoxgender);

//        JRadioButton genderm= new JRadioButton("Male");
//        JRadioButton genderf=new  JRadioButton("Female");
//        genderm.setBounds(190,300,105,30);
//        genderm.setBackground(new Color(210,180,140));
//        genderf.setBounds(290,300,120,30);
//        genderf.setBackground(new Color(210,180,140));
//        patient.add(genderm);
//        patient.add(genderf);

        JLabel bloodlbl = new JLabel("BloodGroup:");
        bloodlbl.setFont(new Font("Verdana", Font.BOLD, 19));
        bloodlbl.setBounds(10,350,140,30);
        bloodlbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(bloodlbl);

        String[] blood_type = {"A+","B+","B-","AB-","AB+","O-","0+","AB-",};
        JComboBox comboBoxblood= new JComboBox(blood_type) ;
        comboBoxblood.setFont(new Font("Verdana", Font.BOLD, 16));
        comboBoxblood.setBounds(190,350,220,30);
        patient.add(comboBoxblood);

//        JTextField bloodtxt= new JTextField(" ");
//        bloodtxt.setBounds(190,350,220,30);
//        bloodtxt.setFont(new Font("Verdana", Font.BOLD, 16));
//        bloodtxt.setBackground(new Color(210,180,160));
//        patient.add(bloodtxt);

        JLabel  address_lbl = new JLabel("Address:");
        address_lbl.setFont(new Font("Verdana",Font.BOLD, 19));
        address_lbl .setBounds(10,450,100,30);
        address_lbl.setBackground(new Color(210,180,140));
        patient.add(address_lbl);

        address_txt= new JTextField(" ");
        address_txt.setBounds(190,450,220,30);
        address_txt.setFont(new Font("Verdana", Font.BOLD, 16));
        address_txt.setBackground(new Color(102, 153, 153));
        patient.add(address_txt);

        JLabel  doctor_lbl = new JLabel("Doctor:");
        doctor_lbl.setFont(new Font("Verdana",Font.BOLD, 19));
        doctor_lbl.setBounds(10,400,100,30);
        doctor_lbl.setBackground(new Color(210,180,140));
        patient.add(doctor_lbl);

        String[] doctor_type = {"Dr.Bibek(Neuro Surgen)","Dr.Bibek(Cardio)","Dr.hari(Mbbs,MD)","Dr.shyam(Radiologist)"};
        JComboBox comboBox= new JComboBox(doctor_type) ;
        comboBox.setFont(new Font("Verdana", Font.BOLD, 14));
        comboBox.setBounds(190,400,220,30);
        patient.add(comboBox);

//        JLabel wardnum   = new JLabel("Ward NO:");
//        wardnum.setFont(new Font("Verdana",Font.BOLD, 19));
//        wardnum.setBounds(10,450,120,30);
//        wardnum.setBackground(new Color(210,180,140));
//        patient.add(wardnum);

//        String[] ward_type = {"A","B","C","D","E","F","G"};
//        JComboBox comboBoxward= new JComboBox(ward_type) ;
//        comboBoxward.setFont(new Font("Verdana", Font.BOLD, 16));
//        comboBoxward.setBounds(190,450,220,30);
//        patient.add(comboBoxward);

//        JTextField wardtxt= new JTextField(" ");
//        wardtxt.setBounds(190,450,220,30);
//        wardtxt.setFont(new Font("Verdana", Font.BOLD, 16));
//        wardtxt.setBackground(new Color(210,180,160));
//        patient.add(wardtxt);
 
        JLabel symptoms   = new JLabel("Symptoms:");
        symptoms.setFont(new Font("Verdana",Font.BOLD, 19));
        symptoms.setBounds(10,500,150,30);
        symptoms.setBackground(new Color(210,180,140));
        patient.add(symptoms);

        symptomstxt= new JTextField(" ");
        symptomstxt.setBounds(190,500,220,30);
        symptomstxt.setFont(new Font("Verdana", Font.BOLD, 16));
        symptomstxt.setBackground(new Color(102, 153, 153));
        patient.add(symptomstxt);

        JLabel admitteddate   = new JLabel("Date:");
        admitteddate.setFont(new Font("Verdana",Font.BOLD, 29));
        admitteddate.setBounds(10,550,150,30);
        admitteddate.setBackground(new Color(210,180,140));
        patient.add(admitteddate);

        admittedtxt = new JTextField(" ");
        admittedtxt.setBounds(190,550,220,30);
        admitteddate.setFont(new Font("Verdana", Font.BOLD, 16));
        admittedtxt.setBackground(new Color(102, 153, 153));
        patient.add(admittedtxt);
//
//        JLabel currentdignosis   = new JLabel("Current Diagnosis:");
//        currentdignosis.setFont(new Font("Verdana",Font.BOLD, 14));
//        currentdignosis.setBounds(10,600,150,30);
//        currentdignosis.setBackground(new Color(210,180,140));
//        patient.add(currentdignosis);
//
//        JTextField diagnosis= new JTextField("");
//        diagnosis.setFont(new Font("Verdana",Font.BOLD, 14));
//        diagnosis.setBounds(190,600,220,100);
//        diagnosis.setBackground(new Color(210,180,140));
//        patient.add(diagnosis);

        addpatientbtn= new JButton("Add Patient");
        addpatientbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String patientname, dob,contact, age, gender,bloodgroup,doctor, address,symptoms, date;
                con = DbConnect.Connect();
                patientname =nametxt.getText();
                dob = dobtxt.getText();
                contact =contacttxt.getText();
                age = agetxt.getText();
                gender = String.valueOf(comboBoxgender.getSelectedItem());
                bloodgroup =String.valueOf(comboBoxblood.getSelectedItem());
                doctor = String.valueOf(comboBox.getSelectedItem());
                address = address_txt.getText();
                symptoms = symptomstxt.getText();
                date = admittedtxt.getText();


                try {
                    String query = "insert into patient(patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date) values(?,?,?,?,?,?,?,?,?,?)";
                    stmt = con.prepareStatement(query);
                    stmt.setString(1,patientname);
                    stmt.setString(2,dob);
                    stmt.setString(3,contact);
                    stmt.setString(4,age);

                    stmt.setString(5,gender);
                    stmt.setString(6,bloodgroup);
                    stmt.setString(7,doctor);
                    stmt.setString(8,address);
                    stmt.setString(9,symptoms);
                    stmt.setString(10,date);
                    stmt.execute();

                    JOptionPane.showMessageDialog(addpatientbtn,"Patient registered successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        addpatientbtn.setBounds(00,630,130,55);
        addpatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        addpatientbtn.setBackground(new Color(160,182,45));
        patient.add(addpatientbtn);

        updatepatientbtn = new JButton("Update Patient");
        updatepatientbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String id,patientname, dob,contact, age, gender,bloodgroup,doctor, address,symptoms, date;
                con = DbConnect.Connect();
                id = idtxt.getText();
                patientname =nametxt.getText();
                dob = dobtxt.getText();
                contact =contacttxt.getText();
                age = agetxt.getText();
                gender = String.valueOf(comboBoxgender.getSelectedItem());
                bloodgroup =String.valueOf(comboBoxblood.getSelectedItem());
                doctor = String.valueOf(comboBox.getSelectedItem());
                address = address_txt.getText();
                symptoms = symptomstxt.getText();
                date = admittedtxt.getText();


                try {
//                String query = "insert into patient(patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date) values(?,?,?,?,?,?,?,?,?,?)";
                    stmt = con.prepareStatement("update patient set patient_name=?,dob=?,contact=?,age=?,gender=?,bloodgroup=?,doctor=?,address=?,symptoms=?,date=? where id=?");
                    stmt.setString(1,patientname);
                    stmt.setString(2,dob);
                    stmt.setString(3,contact);
                    stmt.setString(4,age);
                    stmt.setString(5,gender);
                    stmt.setString(6,bloodgroup);
                    stmt.setString(7,doctor);
                    stmt.setString(8,address);
                    stmt.setString(9,symptoms);
                    stmt.setString(10,date);
                    stmt.setString(11,id);
                    stmt.execute();

                    JOptionPane.showMessageDialog(updatepatientbtn,"Patient updated successfully!");
                    patienttable_remove();
                    table_load();

                    idtxt.setText("");
                    nametxt.setText("");
//
                    dobtxt.setText("");
                    contacttxt.setText("");
                    agetxt.setText("");
                    address_txt.setText("");
                    symptomstxt.setText("");
                    admittedtxt.setText("");


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

        	}
        });

        updatepatientbtn.setBounds(127,630,180,55);
        updatepatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        updatepatientbtn.setBackground(new Color(45, 182, 139));
        patient.add(updatepatientbtn);
        

        resetpatientbtn = new JButton("Reset Patient");
        resetpatientbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                idtxt.setText("");
                nametxt.setText("");
                dobtxt.setText("");
                contacttxt.setText("");
                agetxt.setText("");
                address_txt.setText("");
                symptomstxt.setText("");
                admittedtxt.setText("");

        	}
        });
        resetpatientbtn.setBounds(650,630,220,55);
        resetpatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        resetpatientbtn.setBackground(new Color(45, 182, 139));
        patient.add(resetpatientbtn);

        showadmittedpatientbtn = new JButton("Show Admitted Patient");
        showadmittedpatientbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		new ShowAdmittedPatient().setVisible(true);
        	}
        });
        showadmittedpatientbtn.setBounds(450,630,220,55);
        showadmittedpatientbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        showadmittedpatientbtn.setBackground(new Color(182, 45, 45));
        patient.add(showadmittedpatientbtn);

        JButton uploadlabbtn = new JButton("Upload lab Reports");
        uploadlabbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		new UploadLabReport().setVisible(true);
        	}
        });
        uploadlabbtn.setBounds(290,630,181,55);
        uploadlabbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        uploadlabbtn.setBackground(new Color(45, 182, 139));
        patient.add(uploadlabbtn);

        JLabel  search_lbl = new JLabel("Search By:");
        search_lbl.setFont(new Font("Verdana",Font.BOLD, 19));
        search_lbl.setBounds(801,46,140,30);
        search_lbl.setBackground(new Color(210,180,140));
        patient.add(search_lbl);

        JTextField search_txt= new JTextField(" ");
        search_txt.setBounds(1034,53,120,26);
        search_txt.setFont(new Font("Verdana", Font.BOLD, 16));
        search_txt.setBackground(new Color(210,180,160));
        patient.add(search_txt);

        String[] search_type = {"Id","Name","Address"};
        JComboBox comboBoxsearch= new JComboBox(search_type) ;
        comboBoxsearch.setFont(new Font("Verdana", Font.BOLD, 16));
        comboBoxsearch.setBounds(924,53,100,26);
        patient.add(comboBoxsearch);

        JButton searchbtn= new JButton("Search");
        searchbtn.addActionListener(new ActionListener() {
//********************************Searching***********************//
            public void actionPerformed(ActionEvent e) {
                ArrayList<Vector<String>> res;
                int pos = 0;
                res = new ArrayList<Vector<String>>();
                String query = search_txt.getText();
                query = query.toLowerCase();
                for(Vector<String> i:dataArray ) {
                    if(i.get(pos).toLowerCase().equals(query)) {
                        res.add(i);
                    }
                }
        	}
        });
        searchbtn.setBounds(1164,52,100,30);
        searchbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        searchbtn.setBackground(new Color(160,182,45));
        patient.add(searchbtn);

//        JTable patienttable = new JTable();
////        table.setBounds(100,30,400,500);
//        patienttable.setModel(new DefaultTableModel(
//                new Object[][] {
//                },
//                new String[] {
//                        "Patient ID", "Patient Name", "DOB", "Contact", "Gender","Age", "Blood Group", "Address","Symptoms", "Doctor Assigned","Date"
//                }
//        ));
//
//        model = new DefaultTableModel();
//        patienttable.setModel(model);
//        JScrollPane scrollPane = new JScrollPane(patienttable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setBounds(500, 130, 1000, 445);
//        patient.add(scrollPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(501, 91, 1000, 445);
        patient.add(scrollPane);

        model = new DefaultTableModel();
        patienttable  = new JTable();
        Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender","Age", "Blood Group", "Doctor Assigned","Address","Symptoms", "Date"};
        Object[] row = new Object[0];
        scrollPane.setViewportView(patienttable);
        model.setColumnIdentifiers(column);
        patienttable.setModel(model);
        patienttable.addMouseListener(this);

//        patient.add(patienttable);



        ImageIcon background_img= new ImageIcon("hos.jpg");
        Image img1 = background_img.getImage();
        Image temp_img= img1.getScaledInstance(2000,600,Image.SCALE_SMOOTH);
        background_img=new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.add(patient);

        String[] sort_type = {"Ascending","Descending"};
        comboBoxsort= new JComboBox(sort_type) ;
        comboBoxsort.setFont(new Font("Verdana", Font.BOLD, 16));
        comboBoxsort.setBounds(1374,53,140,26);
        patient.add(comboBoxsort);
        
        JLabel lblNewLabel = new JLabel("Sort BY:");
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 19));
        lblNewLabel.setBounds(1274, 52, 100, 30);
        patient.add(lblNewLabel);

        JButton sortbtn= new JButton("Sort");
        sortbtn.setBounds(1390,22,80,30);
        sortbtn.setFont(new Font("Verdana", Font.BOLD, 14));
        sortbtn.setBackground(new Color(160,182,45));
        patient.add(sortbtn);
        sortbtn.addActionListener(this);

        background.add(heading);
        background.setBounds(0,0,2000,1000);
        getContentPane().add(background);


        setSize(2000,1200);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        table_load();
    }
    public void patienttable_remove() {
        for (int i= model.getRowCount()-1; i >=0; i--){
            model.removeRow(i);
        }
    }

    public void table_load(){
        dataArray = new ArrayList<Vector<String>>();
        try {
            con = DbConnect.Connect();
            String query = "select * from patient";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();

            while(result.next()){
                Vector<String> temp = new Vector<String>();
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
                temp.add(id);
                temp.add(patient_name);
                temp.add(dob);
                temp.add(contact);
                temp.add(age);
                temp.add(gender);
                temp.add(bloodgroup);
                temp.add(doctor);
                temp.add(address);
                temp.add(symptoms);
                temp.add(date);

                model.addRow(new Object[] {id,patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date});
                dataArray.add(temp);

            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static String[][] getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount();
        int nCol = dtm.getColumnCount();
        String[][] tableData = new String[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                tableData[i][j] = (String) dtm.getValueAt(i, j);
            }
        }
        return tableData;
    }
    public String[][] sort(String[][] tableData) {
        for (int i = 0; i < tableData.length; i++) {
            for (int j = 0; j < (tableData.length - i - 1); j++) {
                if (Integer.parseInt(tableData[j][0]) > Integer.parseInt(tableData[j + 1][0])) {
                    Object[] temp = tableData[j];
                    tableData[j] = tableData[j + 1];
                    tableData[j + 1] = (String[]) temp;
                }
            }
        }
        patienttable_remove();
        return tableData;

    }
    public void displaySortedTableData(String[][] tableData) {

        for (int i = 0; i < tableData.length; i++) {
            String id = tableData[i][0];
            String patient_name = tableData[i][1];
            String dob = tableData[i][2];
            String contact = tableData[i][3];
            String age = tableData[i][4];
            String gender = tableData[i][5];
            String bloodgroup = tableData[i][6];
            String doctor = tableData[i][7];
            String address = tableData[i][8];
            String symptoms = tableData[i][9];
            String date = tableData[i][10];
            model.addRow(
                    new Object[] {id,patient_name,dob,contact,age,gender,bloodgroup,doctor,address,symptoms,date });
        }

    }
    public String[][] reverseData(String[][] tableData) {
        for (int i = 0; i < (tableData.length / 2); i++) {

            Object[] temp = tableData[i];
            tableData[i] = tableData[tableData.length - 1 - i];
            tableData[tableData.length - 1 - i] = (String[]) temp;

        }
        return tableData;
    }
    public static void main(String args[])
    {
        new Admins();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
    	  if (e.getSource()==sortbtn);
          String sort_txt = comboBoxsort.getSelectedItem().toString();
          if (sort_txt.equals("Ascending")) {
              String[][] sortData = sort(data);
              displaySortedTableData(sortData);
          }
          if (sort_txt.equals("Descending")) {
              String[][] sortData = sort(data);
              displaySortedTableData(reverseData(sortData));
          }
  //


    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = patienttable.rowAtPoint(e.getPoint());

        idtxt.setText((String) model.getValueAt(row,0));
        nametxt.setText((String) model.getValueAt(row,1));
//
        dobtxt.setText((String) model.getValueAt(row,2));
        contacttxt.setText((String) model.getValueAt(row,3));
        agetxt.setText((String) model.getValueAt(row,4));
        address_txt.setText((String) model.getValueAt(row,8));
        symptomstxt.setText((String) model.getValueAt(row,9));
        admittedtxt.setText((String) model.getValueAt(row,10));
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
		



