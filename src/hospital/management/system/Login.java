package hospital.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.lang.Math.E;


public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    Login(){

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);


        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);


        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,161));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,179,161));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this); //listens to any action performed on b1 button i.e. b1 is clicked
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(190,140,120,30);
        b2.setFont(new Font("",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);  //listens to any action performed on b2 button i.e. b2 is clicked
        add(b2);








        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,280);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1 ){  // checks wether the action performed is b1 button clicked ,login process
            try {

                conn c = new conn(); //creating a connection
                String user = textField.getText(); //the name entered in the textField will get stored in user variable
                String Pass = jPasswordField.getText(); //password entered in the jPasswordField stored in Pass

                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'"; //creates a query to match given info with the database
                ResultSet resultSet = (ResultSet) c.statement.executeQuery(q); //stores the result of matching if given info present in the database in the resultSet

                if (resultSet.next()) {
                    new Reception(); // opens new test window/panel
                    setVisible(false); //closes the login panel

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid"); //if the info not matched with database a temporary window opens showing invalid message with default/null text style
                }


            }catch(Exception E){ //any kind of exception occured in database will be shown on this ide
                E.printStackTrace();
            }


        }else{
            System.exit(10);
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }


}
