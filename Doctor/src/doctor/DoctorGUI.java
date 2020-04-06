/*
 * Created by JFormDesigner on Fri Mar 15 22:23:15 IST 2019
 */

package doctor;

import sun.font.TrueTypeFont;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Boolean.TRUE;



/**
 * @author ajay Singh
 */
public class DoctorGUI extends JFrame {
    Doctor dr = new Doctor();
    public DoctorGUI() {
        initComponents();
        clock();
        String date = new SimpleDateFormat(" dd/MM/yyyy").format(Calendar.getInstance().getTime());
        label4.setText("DATE -"+date);

    }

    private void label10MouseClicked(MouseEvent e) {
        String m=textField1.getText();
        dr.write1(m);

    }

    private void label10MouseReleased(MouseEvent e) {
        label10.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\1.gif"));
       // textField1.setText("");
    }

    private void prescriptionMouseClicked(MouseEvent e) {
        textField1.setVisible(TRUE);
        label10.setVisible(TRUE);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ajax
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label7 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();
        label1 = new JLabel();
        prescription = new JLabel();
        textField1 = new JTextField();
        label10 = new JLabel();

        //======== this ========
        setTitle("Swasthya");
        setIconImage(new ImageIcon("F:\\1P\\Doctor\\img\\hl.png").getImage());
        setFont(new Font("Calibri", Font.PLAIN, 20));
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label2 ----
            label2.setIcon(new ImageIcon("F:\\1P\\Doctor\\img\\Docmain.gif"));

            //---- label3 ----
            label3.setFont(new Font("Calibri", Font.PLAIN, 30));

            //---- label4 ----
            label4.setText("DATE");
            label4.setFont(new Font("Calibri", Font.PLAIN, 30));

            //---- label7 ----
            label7.setText("text");

            //---- label5 ----
            label5.setText("TIME");
            label5.setFont(new Font("Calibri", Font.PLAIN, 30));

            //---- label6 ----
            label6.setText("Application-State(Active)");
            label6.setFont(new Font("Calibri", Font.PLAIN, 25));
            label6.setForeground(new Color(0, 254, 52));

            //---- label8 ----
            label8.setFont(new Font("Calibri", Font.PLAIN, 30));
            label8.setForeground(new Color(0, 254, 52));

            //---- label1 ----
            label1.setIcon(new ImageIcon("F:\\1P\\Doctor\\img\\logo.png"));

            //---- prescription ----
            prescription.setFont(new Font("Calibri", Font.PLAIN, 30));
            prescription.setForeground(new Color(0, 254, 52));
            prescription.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    prescriptionMouseClicked(e);
                }
            });

            //---- textField1 ----
            textField1.setFont(new Font("Calibri", Font.PLAIN, 30));
            textField1.setVisible(false);

            //---- label10 ----
            label10.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\submit.gif"));
            label10.setVisible(false);
            label10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label10MouseClicked(e);
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    label10MouseReleased(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(192, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(195, 195, 195))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(prescription, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label10, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(685, 685, 685)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(prescription, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
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
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void Name(String x)
    {


        if(x!=null){
            label3.setText("Patient's Name - "+x);
            prescription.setText("Write Prescription");

          }
        else{
          //  label3.setText("");

        }

    }

    public void Re(String p)
    {
        if(p!=null){
            label8.setText("Retrieving Documents....");}

        else{
            label8.setText("");
        }

    }




    public void clock()
    {
        Thread clock =new Thread()
        {
            public void run()
            {

                try {
                    while(true){
                        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                        label5.setText("TIME - "+time);
                        sleep(1000);}
                }

                catch(Exception e){}
            }

        };
        clock.start();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ajax
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label7;
    private JLabel label5;
    private JLabel label6;
    private JLabel label8;
    private JLabel label1;
    private JLabel prescription;
    private JTextField textField1;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
