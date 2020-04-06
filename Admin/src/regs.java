import javax.swing.event.*;
import arduino.Arduino;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.amazonaws.services.elasticbeanstalk.model.SystemStatus;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import javax.activation.*;


public class regs extends JFrame {
    private static Arduino a=new Arduino();
    public regs() {

        initComponents();
        button1.setEnabled(false);
    }
    private static regs r = new regs();
    private static Admin adm = new Admin();
    private String f,l,m,ano,dob,bld,add,cno,name,Em,w,au,uname;
private int x=0;

    private void textField9FocusGained(FocusEvent e) {                // First name
        button1.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\submit.gif"));
        textField9.setText("");
        textField9.setForeground(Color.black);
button1.setEnabled(false);

    }
    //   /   /   /       /   /   /   /       /   /   /   /MIDDLE    /////   /   /   /       /   /   /   /   /       /   /   /


    private void textField2FocusGained(FocusEvent e) {              //middle
    clock2();
        f= textField9.getText();
        if((!f.equals("First"))&&(f != null)&& (!f.equals("")) && (f.matches("^[a-zA-Z]*$")))
        {
            textField2.setEditable(true);
            textField2.setText("");
            textField2.setForeground(Color.black);
            label9.setText("");

        }
        else{
            label9.setForeground(Color.red);
            label9.setText("Enter only alphabets");
              textField2.setEditable(false);
        }
    }



    public void clock2( )
    {

        Thread clock =new Thread()
        {
            public void run()
            {
                try {
                    a.setPortDescription("COM4");
                    a.openConnection();
                    stop();
                }
                catch(Exception e){}
            }
        };
        clock.start();

    }







    //   /   /   /       /   /   /   /       /   /   /   /last    /////   /   /   /       /   /   /   /   /       /   /   /


    private void textField3FocusGained(FocusEvent e) {
        m= textField2.getText();
        if((!m.equals("Middle"))&&(m != null)&&(!f.equals("First"))&&(f != null)&&(m!="Middle")&&(m != null)&& (!m.equals("")) && (m.matches("^[a-zA-Z]*$"))) {
            textField3.setEditable(true);
            textField3.setText("");
            textField3.setForeground(Color.black);//last name
            label9.setText("");
        }

        else{
            a.closeConnection();
            textField3.setEditable(false);
            label9.setForeground(Color.red);
            label9.setText("Enter only alphabets");
        }
     }


//      /   /   /       /   /   /       /   /   /   /   /ANO.````/`/`/``/`/`/`//    /   /   /   /   /       /   //


     private void textField4FocusGained(FocusEvent e) {                                       //Aadhar no.
         l= textField3.getText();
         if((l !="Last")&&(l != null)&& (!l.equals("")) && (l.matches("^[a-zA-Z]*$"))&&(!m.equals("Middle"))&&(m != null)&&(!f.equals("First"))&&(f != null)&&(m!="Middle")&&(m != null)&& (!m.equals(""))     ) {
             textField4.setText("");
             textField4.setForeground(Color.black);//last name
             textField4.setEditable(true);
             label9.setText(""); label14.setVisible(true);

             //label14.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\veri.gif"));
         }

         else{
             textField4.setEditable(false);
             label9.setForeground(Color.red);
             label9.setText("Enter only alphabets");
         }

    }
//   /       /   /   /   /       /   /   /   /   /   /   /       /   ///DOB /   /   /   /       /   /   /   /   /   /   /   /   /   /

     private void textField5FocusGained(FocusEvent e) { //dob

         f = textField9.getText();
         String first = f.substring(0,1).toUpperCase();
         String rest = f.substring(1).toLowerCase();

         f=first+rest;

         l = textField3.getText();
         first = l.substring(0,1).toUpperCase();
         rest = l.substring(1).toLowerCase();
         l=first+rest;
         name=f+l;
         ano = textField4.getText();
         au=ano.substring(8,12);
         uname=f+l+au;

         if((ano != null)&& (!ano.equals(""))&&(ano.length()==12) && (ano.matches("^[0-9]*$"))&&(!ano.equals("111122223333")))
         {



             textField5.setEditable(true);
             textField5.setText("");
             textField5.setForeground(Color.black);//last name
             label10.setText("");
             clock1();
         }

         else{

             textField5.setEditable(false);
             label10.setText("Enter a valid 12 digit Aadhar Number");
         }
     }





    public void clock1()
    {
        Thread clock =new Thread()
        {
            public void run()
            {
                try {

                    if(adm.check(f,l,ano)) {
                        label9.setForeground(Color.red);
                        label9.setText("User Already Exists");
                        label14.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\exists.gif"));
                        button2.setVisible(true);
                        textField7.setEnabled(false);
                        textField8.setEnabled(false);
                        textField5.setEnabled(false);
                        textField10.setEnabled(false);
                        comboBox1.setEnabled(false);
                        button1.setVisible(false);
                            stop();
                    }
                    else{
                        label9.setForeground(Color.green);
                        label9.setText("User Verified");
                        label14.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\veri.gif"));
                        adm.encrypt1(uname,Credentials.secret_access_key);
                        stop();
                    }


                }

                catch(Exception e){}
            }

        };
        clock.start();
    }







//  /   /   /   /   /   /   /   /   /   /   /   /   /   /   /   /   /   //  Blood Group //      /   /   /   /   /   /   /   /

    private void comboBox1MousePressed(MouseEvent e) {
        label14.setIcon(new ImageIcon());
        dob = textField5.getText();
        if((!dob.equals("dd/MM/yyyy"))&&(dob != null)&& (!dob.equals(""))&&(dob.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")))
        {

            comboBox1.setSelectedIndex(0);
            comboBox1.setEnabled(true);
            textField7.setEnabled(true);
            textField8.setEnabled(true);
            textField10.setEnabled(false);
            comboBox1.setForeground(Color.black);
            label11.setText("");
        }
        else{
            comboBox1.setSelectedIndex(0);
            comboBox1.setEnabled(false);
            textField7.setEnabled(false);
            textField8.setEnabled(false);
            textField10.setEnabled(false);

//             comboBox1.setEditable(false);
            label11.setText("use dd/mm/yyyy format");

        }
    }

    private void comboBox1FocusGained(FocusEvent e) {
        label14.setVisible(false);
        dob = textField5.getText();
        if((!dob.equals("dd/MM/yyyy"))&&(dob != null)&& (!dob.equals(""))&&(dob.matches("^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$")))
        {
            comboBox1.setSelectedIndex(0);
            comboBox1.setEnabled(true);
            comboBox1.setForeground(Color.black);
            label11.setText("");

        }
        else{
            comboBox1.setEnabled(false);
            comboBox1.setSelectedIndex(0);
            label11.setText("Use dd/mm/yyyy format");

        }
    }

     // /   /   /   /   /   /   //      /   /   /   /   /   /   /   /   /   /phne no.   /// /   /   /   /       /   /   /
     private void textField8FocusGained(FocusEvent e) {//phone no.
        cno=textField7.getText();
   if((!cno.equals("1234512345"))&&(cno != null)&& (!cno.equals(""))&&cno.length()==10)
   {
       label13.setText("");
       textField8.setText("");
       textField8.setForeground(Color.black);
       textField8.setEnabled(true);
     //textField8.setEditable(true);
       textField10.setEnabled(true);
    //    button1.setEnabled(true);
   }
   else{
       label13.setText("Enter a Valid Mobile Number");
      textField8.setEnabled(false);
         }
     }




    private void button1FocusGained(FocusEvent e) {
        if(button1.isEnabled()) {
        button1.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\1.gif"));
        f = textField9.getText();
        String first = f.substring(0, 1).toUpperCase();
        String rest = f.substring(1).toLowerCase();

        f = first + rest;

        l = textField3.getText();
        first = l.substring(0, 1).toUpperCase();
        rest = l.substring(1).toLowerCase();
        l = first + rest;

        name = f + " " + l;
        dob = textField5.getText();
        bld = String.valueOf(comboBox1.getSelectedItem());
        Em = textField8.getText();
        cno = textField7.getText();
        add = textField10.getText();

        w = f + "^" + l + "/" + ano + "|" + Em + "{" + cno + "}#";

        int ln = w.length();
        a.serialWrite(w, ln, 0);
        System.out.print("write done");
        a.closeConnection();
        adm.Depfd(name, dob, bld, cno, Em, add);
    }
    }

    private void button1MouseReleased(MouseEvent e) {
        if(button1.isEnabled()) {
            textField2.setText("Middle");
            textField2.setForeground(Color.lightGray);
            textField3.setText("Last");
            textField3.setForeground(Color.lightGray);
            textField4.setText("111122223333");
            textField4.setForeground(Color.lightGray);
            textField5.setText("dd/MM/yyyy");
            textField5.setForeground(Color.lightGray);
            textField7.setText("1234512345");
            textField7.setForeground(Color.lightGray);
            textField8.setForeground(Color.lightGray);
            textField8.setText("xyz@email.com");
            textField9.setText("First");
            textField9.setForeground(Color.lightGray);
            textField10.setText("");
            comboBox1.setSelectedIndex(0);
            label9.setText("");
            label10.setText("");
            label11.setText("");
            label12.setText("");
            label14.setVisible(false);
            String t = textField2.getText();
        }

    }
//    public void execute(){
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        // method reference introduced in Java 8
//        executorService.submit(this::eup);
//        executorService.submit(this::countB);
//
//        // close executorService
//        executorService.shutdown();
//    }




     private void textField7FocusGained(FocusEvent e) {
         textField7.setText("");
         textField7.setForeground(Color.black);
         textField8.setEnabled(true);
     }



     private void textField10FocusGained(FocusEvent e) {

         Em=textField8.getText();

         if((Em != null)&& (!Em.equals(""))&&(!Em.equals("xyz@email.com"))&&(Em.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$")))
         {
             label17.setText("");
             textField10.setEnabled(true);
             button1.setEnabled(true);

             clock(Em);
         }
         else{
             label17.setText("Enter a Valid Email ID");
             textField10.setEnabled(false);
         }
     }
    public void clock(String ema )
    {
        Thread clock =new Thread()
        {
            public void run()
            {
                try {

                    adm.eup(ema);
                    stop();
                }
                catch(Exception e){}
            }
        };
        clock.start();

    }
     private void textField4MouseExited(MouseEvent e) {

     }

     private void textField4MouseReleased(MouseEvent e) {
      //   label14.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\veri.gif"));
     }

     private void textField4FocusLost(FocusEvent e) {
         // TODO add your code here
     }

     private void textField4InputMethodTextChanged(InputMethodEvent e) {
         // TODO add your code here
     }


     private void textField4CaretUpdate(CaretEvent e) {
         ano=textField4.getText();
         if((ano.length()==12) && (ano.matches("^[0-9]*$"))&&(!ano.equals("111122223333")))
         {
             label14.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\loading.gif"));
         }

     }

     private void button1MouseClicked(MouseEvent e) {
         // TODO add your code here
     }









    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ryue
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        textField7 = new JTextField();
        label8 = new JLabel();
        textField8 = new JTextField();
        button1 = new JButton();
        textField9 = new JTextField();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        comboBox1 = new JComboBox<>();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        textField10 = new JTextField();
        label17 = new JLabel();
        button2 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        setTitle("Swasthya");
        setIconImage(new ImageIcon("F:\\1P\\Admin\\img\\hl.png").getImage());
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(250, 250, 250));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- label1 ----
            label1.setIcon(new ImageIcon("F:\\1P\\Doctor\\img\\logo.png"));

            //---- label2 ----
            label2.setText("Registration Form");
            label2.setFont(new Font("Calibri", Font.PLAIN, 48));

            //======== panel2 ========
            {
                panel2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                panel2.setBackground(Color.white);
                panel2.setFont(new Font("Calibri", Font.PLAIN, 40));
                panel2.setForeground(Color.lightGray);

                //---- label3 ----
                label3.setText("NAME ");
                label3.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- textField2 ----
                textField2.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField2.setText("Middle");
                textField2.setForeground(Color.lightGray);
                textField2.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField2FocusGained(e);
                    }
                });

                //---- textField3 ----
                textField3.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField3.setText("Last");
                textField3.setForeground(Color.lightGray);
                textField3.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField3FocusGained(e);
                    }
                });

                //---- textField4 ----
                textField4.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField4.setText("111122223333");
                textField4.setForeground(Color.lightGray);
                textField4.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField4FocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        textField4FocusLost(e);
                        textField4FocusLost(e);
                        textField4FocusLost(e);
                    }
                });
                textField4.addCaretListener(e -> textField4CaretUpdate(e));

                //---- label4 ----
                label4.setText("AADHAR NUMBER");
                label4.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- label5 ----
                label5.setText("D.O.B");
                label5.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- textField5 ----
                textField5.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField5.setText("dd/MM/yyyy");
                textField5.setForeground(Color.lightGray);
                textField5.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField5FocusGained(e);
                    }
                });

                //---- label6 ----
                label6.setText("BLOOD GROUP");
                label6.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- label7 ----
                label7.setText("CONTACT");
                label7.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- textField7 ----
                textField7.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField7.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                textField7.setText("1234512345");
                textField7.setForeground(Color.lightGray);
                textField7.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField7FocusGained(e);
                    }
                });

                //---- label8 ----
                label8.setText("EMAIL");
                label8.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- textField8 ----
                textField8.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField8.setForeground(Color.lightGray);
                textField8.setText("xyz@email.com");
                textField8.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField8FocusGained(e);
                    }
                });

                //---- button1 ----
                button1.setFont(new Font("Calibri", Font.PLAIN, 48));
                button1.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\Submit.gif"));
                button1.setBorder(new LineBorder(Color.white));
                button1.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        button1FocusGained(e);
                    }
                });
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        button1MouseReleased(e);
                    }
                });

                //---- textField9 ----
                textField9.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField9.setText("First");
                textField9.setForeground(Color.lightGray);
                textField9.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField9FocusGained(e);
                    }
                });

                //---- label9 ----
                label9.setBackground(Color.red);
                label9.setFont(new Font("Calibri", Font.PLAIN, 24));
                label9.setForeground(Color.red);

                //---- label10 ----
                label10.setFont(new Font("Calibri", Font.PLAIN, 24));
                label10.setForeground(Color.red);

                //---- label11 ----
                label11.setFont(new Font("Calibri", Font.PLAIN, 24));
                label11.setForeground(Color.red);

                //---- label12 ----
                label12.setFont(new Font("Calibri", Font.PLAIN, 24));
                label12.setForeground(Color.red);

                //---- label13 ----
                label13.setFont(new Font("Calibri", Font.PLAIN, 24));
                label13.setForeground(Color.red);

                //---- comboBox1 ----
                comboBox1.setFont(new Font("Calibri", Font.PLAIN, 28));
                comboBox1.setBackground(Color.white);
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Select",
                    "A\u2212\t",
                    "A+\t",
                    "B\u2212\t",
                    "B+\t",
                    "AB\u2212\t",
                    "AB+",
                    "O\u2212\t",
                    "O+\t"
                }));
                comboBox1.setMaximumRowCount(9);
                comboBox1.setFocusCycleRoot(true);
                comboBox1.setFocusable(false);
                comboBox1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        comboBox1MousePressed(e);
                    }
                });
                comboBox1.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        comboBox1FocusGained(e);
                    }
                });

                //---- label14 ----
                label14.setIcon(null);

                //---- label16 ----
                label16.setText("ADDRESS");
                label16.setFont(new Font("Calibri", Font.PLAIN, 35));

                //---- textField10 ----
                textField10.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField10.setForeground(Color.black);
                textField10.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField10FocusGained(e);
                    }
                });

                //---- label17 ----
                label17.setForeground(Color.red);
                label17.setFont(new Font("Calibri", Font.PLAIN, 24));

                //---- button2 ----
                button2.setText("Goto Lost Card");
                button2.setFont(new Font("Calibri", Font.PLAIN, 34));
                button2.setVisible(false);

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addComponent(textField10, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                    .addGap(74, 74, 74))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(501, 501, 501)
                                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label16, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(43, 43, 43)))
                                    .addGap(21, 21, 21))))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label10, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                    .addGap(16, 16, 16)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(label15, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField10, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(336, 336, 336)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(257, 257, 257)
                                        .addComponent(label1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


//    public static void fName(String fname,String lname){
//ad.le(fname,lname);
//
//    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ryue
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel2;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField7;
    private JLabel label8;
    private JTextField textField8;
    private JButton button1;
    private JTextField textField9;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JComboBox<String> comboBox1;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JTextField textField10;
    private JLabel label17;
    private JButton button2;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables





}
