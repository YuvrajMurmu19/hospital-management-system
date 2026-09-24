package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class NEW_PATIENT extends JFrame implements ActionListener{ //for adding new patient window

    JComboBox comboBox; // drop down options for id proof
    JTextField textFieldNumber, textName,textFieldDisease, textFieldDeposit; // textfields for different values to be entered by new patient
    JRadioButton r1,r2; //male or female
    Choice c1; //giving the new patient options
    JLabel date; //date of adding new patient
    JButton b1,b2; //for submitting or canceling

    NEW_PATIENT(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png")); //imageicon for loading the image
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);//converting imageicon to image and scaling it
        ImageIcon imageIcon1 = new ImageIcon(image); //again loading the scaled image
        JLabel label = new JLabel(imageIcon1);//you have to convert the image into label
        label.setBounds(550,150,200,200);
        panel.add(label); //adding the label to the panel

        JLabel labelName = new JLabel("NEW PATIENT FORM");//adding form title
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("",Font.BOLD,20));
//        labelName.setForeground(Color.black);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter ID","Driver License"});
        comboBox.setBounds(271,76,150,20);
        comboBox.setBackground(Color.orange);
        comboBox.setBackground(Color.pink);
        comboBox.setFont(new Font("",Font.PLAIN,14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :"); //for asking the number on the id type e.g. adhaar number
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        textFieldNumber.setBackground(Color.pink);
        panel.add(textFieldNumber);

        JLabel Name = new JLabel("Name :");
        Name.setBounds(35,150,200,14);
        Name.setFont(new Font("",Font.BOLD,14));
        Name.setForeground(Color.white);
        panel.add(Name);

        textName = new JTextField();
        textName.setBounds(271,146,150,20);
        textName.setBackground(Color.pink);
        panel.add(textName);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(35,190,150,14);
        gender.setFont(new Font("",Font.BOLD,14));
        gender.setForeground(Color.white);
        panel.add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("",Font.BOLD,14));
        r1.setBounds(271,190,80,15);
        r1.setBackground(new Color(90,156,163));
//        r1.setLayout(null);

        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("",Font.BOLD,15));
        r2.setBounds(350,190,80,15);
        r2.setBackground(new Color(90,156,163));
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        //set label for disease and its text field in place of country wala

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,230,150,14);
        labelDisease.setFont(new Font("",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,230,150,20);
        textFieldDisease.setBackground(Color.pink);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35,271,150,14);
        labelRoom.setFont(new Font("",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        //Room choice//
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room"); //resultset is used to import the data from the sql database using executeQuery
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
                }



        }catch(Exception e){
            e.printStackTrace();

        }


        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(Color.pink);
        panel.add(c1);


        JLabel labelDate = new JLabel("Date :"); //creates the label for date :
        labelDate.setBounds(35,311,150,14);
        labelDate.setFont(new Font("",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date(); //imports date class to show date and stores that date in date1
        date = new JLabel(""+date1); //date1 is shown in the date JLabel
        date.setBounds(271,311,180,20);
        panel.add(date);

        //
        JLabel deposit = new JLabel("Deposit :");
        deposit.setBounds(35,355,150,14);
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("",Font.BOLD,14));
        panel.add(deposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,355,150,20);
        textFieldDeposit.setBackground(Color.pink);
        panel.add(textFieldDeposit);

        b1 = new JButton("ADD");
        b1.setBounds(100,410,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260,410,120,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false); // clicking on back button will set the visibility of jframe false i.e. invisible
            }
        });

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(310,230);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            conn c = new conn();
//            Statement st = c.createStatement(); // something for error but not working :(
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }
            else if(r2.isSelected()){
                radioBTN = "Female";
            }
            String s1 = (String)comboBox.getSelectedItem();//will store the item selected in comboBox to s1
            String s2 = textFieldNumber.getText();// will store text in textFieldNumber in s2
            String s3 = textName.getText();// will store the text from textName in s3
            String s4 = radioBTN; // radioBTN string copied in s4
            String s5 = textFieldDisease.getText(); //will store the text from textFieldDisease to s5
            String s6 = c1.getSelectedItem();//c1 is choice type then storing the selected choice from c1 into s6
            String s7 = date.getText(); // stores the text from date into string s7
            String s8 = textFieldDeposit.getText();//stores the text from textFieldDeposit into string s8

            try{
                //here we will write queries and store these strings s1,s2,s3..... into database
                String q= "insert into patient_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')"; //sql syntax occured here now ok but keep in mind correct syntax for sql
                // q query will store the strings in the database but it must be in the same order as the form so that each string goes to the matching column
                String q1 = "update Room set Availability = 'Occupied' where room_no = "+s6;
                //q1 query will change the status of the rooms from Availabil to Occupied
                 c.statement.executeUpdate(q);//the query q is executed through this command
                c.statement.executeUpdate(q1);//the query q1 is executed through this command
                JOptionPane.showMessageDialog(null,"Added Successfully");
                //JOptionPane will open a window and show the string added successfully iff both query q and q1 executed succesfully
                setVisible(false);//when the queries added succesfully make the new patient window close



            }catch(Exception E){
                E.printStackTrace();// for any error
            }


        }else{
            setVisible(false);//when back button b2 clicked
        }

    }


    public static void main(String[] args){
        new NEW_PATIENT();
    }



}
