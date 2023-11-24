package System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

 

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 

 

public class Hlogin extends JFrame implements ActionListener {
    JLabel titlelbl;
    JLabel usernamelbl;
    JLabel rolelbl;
    JLabel passwordlbl;

 

    JTextField txtname;
    JComboBox roletxt;
    JPasswordField txtpassword;

 

    JButton loginbtn;
    JButton clearbtn;
    JButton registerbtn;

 

    Connection conn = null;

 

    Hlogin() {
        setTitle("Login");
        setLayout(null);

 

 

        titlelbl=new JLabel("LoginPage");

 

        usernamelbl=new JLabel("Username:");
        rolelbl=new JLabel("Role:");

 

        passwordlbl=new JLabel("Password:");

 

        txtname=new JTextField(10);
        String role[]={"Admin","Doctor","Nurse","LabAdmin"};
        roletxt = new JComboBox(role);
        roletxt.setBackground(Color.RED);
        txtpassword=new JPasswordField(10);

 

        loginbtn=new JButton("LoginPage");
        clearbtn=new JButton("Clear");
        registerbtn=new JButton("Register");

 

        loginbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        registerbtn.addActionListener(this);

 

        titlelbl = new JLabel("LoginPage");
        titlelbl.setBackground(Color.YELLOW);
        titlelbl.setBounds(120, 40, 500, 40);

 

        titlelbl.setForeground(new Color(220,0,0,60));
        titlelbl.setFont(new Font("Arial", Font.BOLD, 30));

 

        usernamelbl.setBounds(160, 200, 75, 25);
        rolelbl.setBounds(170, 120, 75, 25);
        passwordlbl.setBounds(160, 290, 75, 25);

 

        txtname.setBounds(100, 240, 200, 25);
        roletxt.setBounds(100, 160, 200, 25);
        txtpassword.setBounds(100, 320, 200, 25);

 

        clearbtn.setBounds(150, 440, 80, 25);
        clearbtn.setBackground(Color.BLUE);
        loginbtn.setBounds(150, 390, 80, 25);
        loginbtn.setBackground(Color.GREEN);

 

        registerbtn.setBounds(148, 490, 85, 25);
        registerbtn.setBackground(Color.GREEN);

 

        add(titlelbl);
        add(usernamelbl);
        add(txtname);

 

        add(rolelbl);
        add(roletxt);

 

        add(passwordlbl);
        add(txtpassword);

 

        add(loginbtn);
        add(clearbtn);
        add(registerbtn);

 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 520);
        setVisible(true);

 

//connection start
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","*#123Nitesh*#");

 

 

        } catch (SQLException ex) {
// handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

 

//connection end
    }

 

    public static void main(String[] args) {
        Hlogin f = new Hlogin();
    }

 

 

    public void reset() {
        txtname.setText("");
        txtpassword.setText("");
    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

 

        if(source==loginbtn) {
            String name=txtname.getText();
            String role=roletxt.getItemAt(roletxt.getSelectedIndex()).toString();
            String password=txtpassword.getText();

 

            String sql = "select id from register where name=? and role=? and password=?";

 

            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, role);
                stmt.setString(3, password);

 

                ResultSet rs = stmt.executeQuery();
//
                while (rs.next()) {

 

                    String id = rs.getString("id");
                    JOptionPane.showMessageDialog(null, "Login successful");
// System.out.println("!!!!! Login Success !!!!!");
                    if (role.equals("Admin")) {
                        Admins f = new Admins();
                        dispose();
                    }else if (role.equals("Doctor")) {
                        Doctors f = new Doctors();
                        dispose();
                    }else if (role.equals("Nurse")) {
                        Nurse f = new Nurse();
                        dispose();

 

                    }
                    reset();

 

                }

 

            } catch (Exception ee) {
                ee.printStackTrace();

 

            }

 

 

        } else if (source == clearbtn) {
            reset();
        } else if (source == registerbtn) {
            Hregister register = new Hregister();
            dispose();
        }

 

 

    }
}