package System;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class UploadLabReport extends JFrame implements ActionListener, MouseListener {
    Connection con;
    PreparedStatement stmt;
    PreparedStatement stmt1;
    DefaultTableModel model;
    JTable patienttable;
    DefaultTableModel model2;
    JTextField nametxt;
    JTextField idtxt;
    JTable labtable;
    JButton addbtn;
    JButton choosebtn;
    JButton adminbtn;
    JButton resetbtn;
    JTextField  uploadfiletxt;
    File file;
    JLabel sp1;
    UploadLabReport()
    {
        // ------------------font---------------------
        Font f= new Font("Serif",Font.BOLD,50);
        Font f1= new Font("Serif",Font.BOLD,30);
        // -----      -------------- header-----------------
        JPanel heading;
        heading = new JPanel();
       
        heading.setBounds(0,0,1350,100);

        JLabel name = new JLabel("Hospital System");
        name.setForeground(Color.BLACK);
        name.setBounds(130,20,900,50);
        name.setFont(f);
        heading.add(name);

        JPanel patient = new JPanel();
        patient.setLayout(null);
        patient.setSize(1600,1200);
      
        patient.setBounds(30,120,1850,900);

        sp1 = new JLabel();
        sp1.setBounds(10,480,500,100);
        patient.add(sp1);

        JLabel name1 = new JLabel(" Upload Patient lab report");
        name1.setForeground(Color.BLACK);
        name1.setBounds(50,10,500,35);
        name1.setFont(f1);
        patient.add(name1);
        JLabel name3 = new JLabel(" All Patients Details");
        name3.setForeground(Color.BLACK);
        name3.setBounds(870,10,500,35);
        name3.setFont(f1);
        patient.add(name3);

        JLabel patientdetails = new JLabel("Patient lab Report");
        patientdetails.setForeground(Color.BLACK);
        patientdetails.setBounds(800,280,500,35);
        patientdetails.setFont(f1);
        patient.add(patientdetails);

        JLabel namelbl = new JLabel("Patient Name:");
        namelbl.setBounds(10,170,220,30);
        namelbl.setFont(new Font("Verdana", Font.BOLD, 18));
        namelbl.setBackground(new Color(215, 205, 205, 24));
        patient.add(namelbl);

        nametxt= new JTextField(" ");
        nametxt.setBounds(190,170,220,30);
        nametxt.setFont(new Font("Verdana", Font.BOLD, 16));
        nametxt.setBackground(new Color(210,180,160));
        patient.add(nametxt);


        JLabel  patientid  = new JLabel("Patient ID:");
        patientid.setFont(new Font("Verdana", Font.BOLD, 19));
        patientid.setBounds(10,82,130,30);
        patientid.setBackground(new Color(215, 205, 205, 24));
        patient.add(patientid);
//
        idtxt= new JTextField(" ");
        idtxt.setBounds(190,82,220,30);
        idtxt.setFont(new Font("Verdana", Font.BOLD, 16));
        idtxt.setBackground(new Color(210,180,160));
        patient.add(idtxt);

        JLabel uploadfile  = new JLabel("File Name:");
        uploadfile.setFont(new Font("Verdana", Font.BOLD, 19));
        uploadfile.setBounds(10,250,130,30);
        uploadfile.setBackground(new Color(215, 205, 205, 24));
        patient.add(uploadfile);

        uploadfiletxt= new JTextField(" ");
        uploadfiletxt.setBounds(190,250,220,30);
        uploadfiletxt.setFont(new Font("Verdana", Font.BOLD, 16));
        uploadfiletxt.setBackground(new Color(210,180,160));
        patient.add(uploadfiletxt);


//  ----------------------------buttons---------------------------
        choosebtn= new JButton("Choose File");
        choosebtn.setBounds(70,330,170,55);
        patient.add(choosebtn);

        addbtn= new JButton("upload Report");
        addbtn.setBounds(300,330,200,55);
        patient.add(addbtn);

        adminbtn= new JButton("Admin Dashboard");
        adminbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               dispose();
               Admins a = new Admins();
            }
        });
        adminbtn.setBounds(300,430,170,55);
        patient.add(adminbtn);

        resetbtn= new JButton("Clear");
        resetbtn.setBounds(70,430,170,55);
        patient.add(resetbtn);
//        ----------------------------------------------------------------------------------------------

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(600, 80, 700, 200);
        patient.add(scrollPane);
        model = new DefaultTableModel();
        patienttable  = new JTable();
        Object[] column = {"Patient ID", "Patient Name", "DOB", "Contact", "Gender","Age", "Blood Group", "Doctor Assigned","Address","Symptoms", "Date"};
        Object[] row = new Object[0];
        scrollPane.setViewportView(patienttable);
        model.setColumnIdentifiers(column);
        patienttable.setModel(model);
        patienttable.addMouseListener(this);

        JScrollPane scrollPanell = new JScrollPane();
        scrollPanell.setBounds(600, 350, 700, 200);
        patient.add(scrollPanell);
        model2 = new DefaultTableModel();
        labtable = new JTable();
        Object[] columnn = {"Patient ID", "File Name", "upload Date"};
        Object[] roww = new Object[0];
        scrollPanell.setViewportView(labtable);
        model2.setColumnIdentifiers(columnn);
        labtable.setModel(model2);
        labtable.addMouseListener(this);





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
        displaypatientlabreport();

        choosebtn.addActionListener(this);
        addbtn.addActionListener(this);
        adminbtn.addActionListener(this);
        resetbtn.addActionListener(this);



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
    public void  medicinetable_remove() {
        for (int i = model2.getRowCount() - 1; i >= 0; i--) {
            model2.removeRow(i);
        }

    }

    public boolean displaypatientlabreport() {

        try {

            String sql = "select * from lab_report";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                String patientid = res.getString(1);
                String filepath = res.getString(2);
                String uploaddate = res.getString(3);
                model2.addRow(new Object[] { patientid, filepath, uploaddate });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(sp1.getWidth(), sp1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public static void main(String args[]){
        new UploadLabReport();}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == choosebtn) {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("D://labreport"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
            fileChooser.addChoosableFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                uploadfiletxt.setText("");
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                uploadfiletxt.setText(file.toString());
            }

        }
//
//        if (source == resetbtn) {
//            reset();
//        }
//
//        if (source == backbtn) {
//            dispose();
//        }

        if (source == addbtn) {

            String patientid = idtxt.getText();
            String filepath = uploadfiletxt.getText();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();

            if (!patientid.isEmpty() && !filepath.isEmpty()) {
                con = DbConnect.Connect();

                String sql = "insert into lab_report(patient_id,file_path,uploaded_date) values(?,?,?)";
                try {
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, patientid);
                    stmt.setString(2, filepath);
                    stmt.setString(3, dtf.format(now));
                    int ins = stmt.executeUpdate();
                    if (ins > 0) {
                        JOptionPane.showMessageDialog(null, "Patient Lab Report Uploaded successful");
                        medicinetable_remove();
                        displaypatientlabreport();
//                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Upload Patient Lab Report");
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Failed to Upload Patient Lab Report");
            }

        }

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==patienttable){
            int row = patienttable.rowAtPoint(e.getPoint());
            idtxt.setText((String) model.getValueAt(row,0));
            nametxt.setText((String) model.getValueAt(row,1));



        }
       if (e.getSource()==labtable){
           int row = labtable.rowAtPoint(e.getPoint());
           sp1.setIcon(ResizeImage(model2.getValueAt(row, 1).toString()));
       }

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
