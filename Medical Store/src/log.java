import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;

public class log extends JFrame {
    private static int i=0,c=0,reset;

    private static medical me=new medical();
    private static String tn,un,date;
    public static String[] upn = new String[10];

    private static DefaultTableModel model = new DefaultTableModel();
    public log() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        initComponents();

        String date = new SimpleDateFormat(" dd/MM/yyyy").format(Calendar.getInstance().getTime());
        //table1.setFont(new Font("Calibri", Font.PLAIN, 24));


        Object[] columns = {"Date","Name","MEDICINE"};
        model.setColumnIdentifiers(columns);

        table1.setModel(model);
        TableColumn column = table1.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        TableColumn column1 = table1.getColumnModel().getColumn(1);
        column1.setPreferredWidth(200);
        TableColumn column2 = table1.getColumnModel().getColumn(2);
        column2.setPreferredWidth(300);

        Font f = new Font("Calibri", Font.BOLD, 25);
        JTableHeader header = table1.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.green);
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




    public void read(int reset)
    {
        System.out.println(reset);

            try {
                if(reset==1) {
                    System.out.println(reset);
                FileReader reader = new FileReader("D:\\1P\\Doctor\\log");
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    int n = line.indexOf("#");
                    int te = line.indexOf("*");

                    un = line.substring(0, n);
                    tn = line.substring(n+ 1, te);
                    date = line.substring(te + 1, te + 11);
                    logrec();
                }
                    reader.close();
                }
                else
                {
                    int rows = table1.getRowCount();
                    for(int x=0;x<rows;x++){
                        ((DefaultTableModel)table1.getModel()).removeRow(i);
                }
                    FileReader reader = new FileReader("D:\\1P\\Doctor\\log");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        int n = line.indexOf("#");
                        int te = line.indexOf("*");

                        un = line.substring(0, n);
                        tn = line.substring(n + 1, te);
                        date = line.substring(te + 1, te + 11);
                        logrec();
                    }
                    reader.close();
                }





            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }





    public void  logrec()
    {
       // String date = new SimpleDateFormat(" dd/MM/yyyy").format(Calendar.getInstance().getTime());
        Object[] row = new Object[4];

        if(true){
            row[0] = date;
            row[1] = un;
            row[2] = tn;
            // add row to the model


            model.addRow(row);}


    }




        private void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - ajax
            panel1 = new JPanel();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            table1 = new JTable();

            //======== this ========
            setBackground(Color.white);
            setTitle("Swasthya");
            setIconImage(new ImageIcon("F:\\1P\\pathology\\img\\hl.png").getImage());
            setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            Container contentPane = getContentPane();

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
                , 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
                , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
                panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
                ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- label1 ----
                label1.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\logo.png"));

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setFont(new Font("Calibri", Font.PLAIN, 24));
                    table1.setRowHeight(45);
                    table1.setRowMargin(3);
                    table1.setFillsViewportHeight(true);
                    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane1.setViewportView(table1);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(304, 304, 304)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
                            .addGap(251, 251, 251))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1024, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 872, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(172, Short.MAX_VALUE))
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
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            pack();
            setLocationRelativeTo(getOwner());
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - ajax
        private JPanel panel1;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable table1;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }


