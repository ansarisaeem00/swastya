import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static java.lang.Integer.parseInt;

public class pathoGUI extends JFrame {
    private static selectfile sf;
    private static int reset=0;
    private static log lo;
    static {
        try {
            sf = new selectfile();
            lo = new log();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static patho pa=new patho();
    private static String test ,un,p;

     public pathoGUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        initComponents();

        String date = new SimpleDateFormat(" dd/MM/yyyy").format(Calendar.getInstance().getTime());

        label14.setText("- "+date);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button2MousePressed(MouseEvent e) {

        sf.setResizable(false);                 //disable's Max
        sf.setVisible(true);
    }

    public void Name(String n,String c)
    {
un=n;
p=c;
        if(c!=null&& n!=null){
            label8.setText("- "+n);
            label10.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\submit.gif"));
label2.setText("- "+c);
            textField1.setEnabled(true);
            label10.setEnabled(true);
        }
        else{
            label8.setText("");
            label2.setText("");
        }

    }






    private void label4MouseClicked(MouseEvent e) {
        sf.setResizable(false);                 //disable's Max
        sf.setVisible(true);
    }

    private void label10MouseClicked(MouseEvent e) {
        label10.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\1.gif"));
       test= textField1.getText();
       write(un,p,test);
label8.setText("");
label2.setText("");
textField1.setText("");
    }





    public static void write(String un,String p, String test)
    {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        String w=un+"#"+p+"%"+test+"*"+date;
        try {
            File file = new File("log");
            if(file.exists()) {
                FileWriter writer = new FileWriter("log", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.newLine();
                bufferedWriter.write(w);
                bufferedWriter.close();}
            else
            {
                FileWriter writer = new FileWriter("log", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(w);
                bufferedWriter.close();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }





    private void label5MouseClicked(MouseEvent e) {
        lo.setResizable(false);                 //disable's Max
        lo.setVisible(true);
        reset++;

        lo.read(reset);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ryue
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label11 = new JLabel();
        textField1 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label10 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setTitle("Swasthya");
        setFont(new Font("Dialog", Font.PLAIN, 20));
        setIconImage(new ImageIcon("F:\\1P\\pathology\\img\\hl.png").getImage());
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- label1 ----
            label1.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\logo.png"));

            //---- label3 ----
            label3.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\header.gif"));

            //---- label7 ----
            label7.setText("Name");
            label7.setFont(new Font("Calibri", Font.PLAIN, 40));
            label7.setForeground(new Color(85, 85, 85));

            //---- label8 ----
            label8.setFont(new Font("Calibri", Font.PLAIN, 40));

            //---- label9 ----
            label9.setText("Contact");
            label9.setFont(new Font("Calibri", Font.PLAIN, 40));
            label9.setForeground(new Color(85, 85, 85));

            //---- label11 ----
            label11.setText("Medical Test");
            label11.setFont(new Font("Calibri", Font.PLAIN, 40));
            label11.setForeground(new Color(85, 85, 85));

            //---- textField1 ----
            textField1.setFont(new Font("Calibri", Font.PLAIN, 40));
            textField1.setEnabled(false);

            //---- label12 ----
            label12.setText("Patients Information");
            label12.setFont(new Font("Calibri", Font.PLAIN, 48));

            //---- label13 ----
            label13.setText("Date");
            label13.setFont(new Font("Calibri", Font.PLAIN, 40));
            label13.setForeground(new Color(85, 85, 85));

            //---- label14 ----
            label14.setFont(new Font("Calibri", Font.PLAIN, 40));

            //---- label2 ----
            label2.setFont(new Font("Calibri", Font.PLAIN, 40));

            //---- label4 ----
            label4.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\upload.gif"));
            label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label4.setBorder(new LineBorder(Color.gray, 2, true));
            label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label4MouseClicked(e);
                }
            });

            //---- label5 ----
            label5.setFont(new Font("OCR-A BT", Font.PLAIN, 22));
            label5.setForeground(Color.blue);
            label5.setBorder(new LineBorder(Color.gray, 2, true));
            label5.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\l1.png"));
            label5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label5MouseClicked(e);
                }
            });

            //---- label10 ----
            label10.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\submit.gif"));
            label10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label10MouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(108, 108, 108))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(499, 499, 499)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label9, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(196, 196, 196)
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(325, 325, 325)
                                        .addComponent(label10)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(label12)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label7)
                                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label11)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addComponent(label10))
                            .addComponent(label4))
                        .addGap(113, 113, 113))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ryue
    private JPanel panel1;
    private JLabel label1;
    private JLabel label3;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label11;
    private JTextField textField1;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

