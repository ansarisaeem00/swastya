import javax.swing.event.*;

import arduino.Arduino;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.amazonaws.services.elasticbeanstalk.model.SystemStatus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;


public class Lost extends JFrame {
    private static Arduino a=new Arduino();
    public Lost() {
        initComponents();
        button1.setEnabled(false);
    }
    private static regs r = new regs();
    private static Admin adm = new Admin();
    private String f,l,m,ano,dob,bld,add,cno,name,Em,w;
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
                    a.setPortDescription("COM3");
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
         }

         else{
             textField4.setEditable(false);
             label9.setForeground(Color.red);
             label9.setText("Enter only alphabets");
         }

    }

     // /   /   /   /   /   /   //      /   /   /   /   /   /   /   /   /   /phne no.   /// /   /   /   /       /   /   /
     private void textField8FocusGained(FocusEvent e) {//phone no.

     }




    private void button1FocusGained(FocusEvent e)
    {
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

        Em = textField5.getText();
        cno = textField7.getText();






        if((Em != null)&& (!Em.equals(""))&&(!Em.equals("xyz@email.com"))&&(Em.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$")))
        {
            w=f+"^"+l+"/"+ano+"|"+Em+"{"+cno+"}#";
            int ln = w.length();
            a.serialWrite(w, ln, 0);
            System.out.print("write done");
            a.closeConnection();

        }
else{
    button1.setEnabled(false);
        }

    }

    private void button1MouseReleased(MouseEvent e) {
        if(button1.isEnabled()) {

            textField9.setText("First");
            textField9.setForeground(Color.lightGray);
            textField2.setText("Middle");
            textField2.setForeground(Color.lightGray);
            textField3.setText("Last");
            textField3.setForeground(Color.lightGray);
            textField4.setText("111122223333");
            textField4.setForeground(Color.lightGray);
            textField7.setText("1234512345");
            textField7.setForeground(Color.lightGray);
            textField5.setForeground(Color.lightGray);
            textField5.setText("xyz@email.com");

            label9.setText("");
            label10.setText("");
            label14.setText("");
        }
    }





     private void textField7FocusGained(FocusEvent e) {
ano=textField4.getText();
         if((ano != null)&& (!ano.equals(""))&&(ano.length()==12) && (ano.matches("^[0-9]*$"))&&(!ano.equals("111122223333")))
         {
             textField7.setEditable(true);
             textField7.setText("");
             textField7.setForeground(Color.black);//last name
             label10.setText("");
         }

         else{
             textField7.setEditable(false);
             label10.setText("Enter a valid 12 digit Aadhar Number");
         }
     }




     private void textField5FocusGained(FocusEvent e) {
         // TODO add your code here
         cno=textField7.getText();
         if((!cno.equals("1234512345"))&&(cno != null)&& (!cno.equals(""))&&cno.length()==10)
         {
             label13.setText("");
             textField5.setText("");
             textField5.setForeground(Color.black);
             textField5.setEditable(true);
              button1.setEnabled(true);

         }
         else{
             label13.setText("Enter a Valid Mobile Number");
             textField5.setEditable(false);
         }
     }

     private void textField4FocusLost(FocusEvent e) {
         // TODO add your code here
     }

     private void textField9FocusLost(FocusEvent e) {
         // TODO add your code here
     }



     private void textField5CaretUpdate(CaretEvent e) {
        Em=textField5.getText();
         if((Em != null)&& (!Em.equals(""))&&(!Em.equals("xyz@email.com"))&&(Em.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$")))
         {
             button1.setEnabled(true);
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
        label7 = new JLabel();
        textField7 = new JTextField();
        label8 = new JLabel();
        button1 = new JButton();
        textField9 = new JTextField();
        label9 = new JLabel();
        label10 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label17 = new JLabel();
        button2 = new JButton();
        textField5 = new JTextField();
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

                //---- label4 ----
                label4.setText("AADHAR NUMBER");
                label4.setFont(new Font("Calibri", Font.PLAIN, 35));

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
                    @Override
                    public void focusLost(FocusEvent e) {
                        textField9FocusLost(e);
                    }
                });

                //---- label9 ----
                label9.setBackground(Color.red);
                label9.setFont(new Font("Calibri", Font.PLAIN, 24));
                label9.setForeground(Color.red);

                //---- label10 ----
                label10.setFont(new Font("Calibri", Font.PLAIN, 24));
                label10.setForeground(Color.red);

                //---- label13 ----
                label13.setFont(new Font("Calibri", Font.PLAIN, 24));
                label13.setForeground(Color.red);

                //---- label14 ----
                label14.setIcon(null);

                //---- label17 ----
                label17.setForeground(Color.red);
                label17.setFont(new Font("Calibri", Font.PLAIN, 24));

                //---- button2 ----
                button2.setText("Goto Lost Card");
                button2.setFont(new Font("Calibri", Font.PLAIN, 34));
                button2.setVisible(false);

                //---- textField5 ----
                textField5.setForeground(Color.lightGray);
                textField5.setText("xyz@email.com");
                textField5.setFont(new Font("Calibri", Font.PLAIN, 40));
                textField5.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        textField5FocusGained(e);
                    }
                });
                textField5.addCaretListener(e -> textField5CaretUpdate(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                    .addGap(520, 520, 520)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
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
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(43, 43, 43)))
                                    .addGap(21, 21, 21))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label17, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                            .addGap(397, 397, 397))
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
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                            .addGap(14, 14, 14)
                                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(label15, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                            .addGap(57, 57, 57)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(227, 227, 227))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
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
    private JLabel label7;
    private JTextField textField7;
    private JLabel label8;
    private JButton button1;
    private JTextField textField9;
    private JLabel label9;
    private JLabel label10;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label17;
    private JButton button2;
    private JTextField textField5;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
