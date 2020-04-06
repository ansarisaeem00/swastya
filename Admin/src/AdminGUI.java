import arduino.Arduino;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Mar 14 22:28:42 IST 2019
 */



/**
 * @author ajay Singh
 */
public class AdminGUI extends JFrame {
    private static Arduino ar=new Arduino();
    public AdminGUI() {
        initComponents();

    }

    private void button1ActionPerformed(ActionEvent e) {

    }

    private void button1MousePressed(MouseEvent e) {

        regs r=new regs();
        r.setVisible(true);
    }

    private void button2MousePressed(MouseEvent e) {
        Lost l=new Lost();
l.setVisible(true);
    }

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ajax
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label6 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setTitle("Swasthya");
        setIconImage(new ImageIcon("F:\\1P\\Admin\\img\\hl.png").getImage());
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setIcon(new ImageIcon("D:\\logo.png"));

            //---- label3 ----
            label3.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\header.gif"));

            //---- label5 ----
            label5.setText("Lost card");
            label5.setFont(new Font("Calibri", Font.PLAIN, 48));
            label5.setForeground(new Color(210, 0, 139));

            //---- button1 ----
            button1.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\regs.gif"));
            button1.setAutoscrolls(true);
            button1.setBackground(new Color(192, 241, 250));
            button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button1.addActionListener(e -> button1ActionPerformed(e));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button1MousePressed(e);
                }
            });
            button1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    button1KeyPressed(e);
                }
            });

            //---- button2 ----
            button2.setIcon(new ImageIcon("F:\\1P\\Admin\\img\\33cIRY4.gif"));
            button2.setBackground(new Color(192, 241, 250));
            button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button2MousePressed(e);
                }
            });

            //---- label6 ----
            label6.setText("Registration");
            label6.setFont(new Font("Calibri", Font.PLAIN, 48));
            label6.setForeground(new Color(210, 0, 139));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(108, 108, 108))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(button1)
                            .addComponent(button2))
                        .addGap(200, 200, 200))
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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponent
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ajax
    private JPanel panel1;
    private JLabel label1;
    private JLabel label3;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
