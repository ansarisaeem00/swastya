import java.awt.*;
import java.awt.event.*;
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



public class selectfile extends JFrame {
    private static int i=0,c=0;
    private static patho pa=new patho();
    private static String Fn,path;
   public static String[] upn = new String[10];

   private static DefaultTableModel model = new DefaultTableModel();
    public selectfile() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        initComponents();

        String date = new SimpleDateFormat(" dd/MM/yyyy").format(Calendar.getInstance().getTime());
        //table1.setFont(new Font("Calibri", Font.PLAIN, 24));


        Object[] columns = {"Sr no.","Name","Source"};
        model.setColumnIdentifiers(columns);

        table1.setModel(model);
        TableColumn column = table1.getColumnModel().getColumn(0);
        column.setPreferredWidth(80);
        TableColumn column1 = table1.getColumnModel().getColumn(1);
        column1.setPreferredWidth(250);
        TableColumn column2 = table1.getColumnModel().getColumn(2);
        column2.setPreferredWidth(570);

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

    private void button2MousePressed(MouseEvent e) {
        JFileChooser ch=new JFileChooser();
        ch.setPreferredSize(new Dimension(800,600));
        ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
        ch.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        ch.setMultiSelectionEnabled(true);
        ch.setAcceptAllFileFilterUsed(false);
        ch.showOpenDialog(null);
        ch.setDialogTitle("open");

        File[] files = ch.getSelectedFiles();
        for(int i=0;i<files.length;i++)
        {
            System.out.println(files[i]);
        }

    }

    private void label2MouseClicked(MouseEvent e) {
        JFileChooser ch=new JFileChooser();
        ch.setPreferredSize(new Dimension(800,600));
        ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
        ch.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        ch.setMultiSelectionEnabled(true);
        ch.setAcceptAllFileFilterUsed(false);
        ch.showOpenDialog(null);
        ch.setDialogTitle("open");
        File f= ch.getSelectedFile();
        Fn=f.getAbsolutePath();
        File[] files = ch.getSelectedFiles();
        for(int k=0;k<files.length;k++)
        {
            path=files[k].toString();
            path=path.replaceAll("\\\\", "\\\\\\\\");
            wt(path);
        }
    }

    public void  wt(String Path)
{

    System.out.println(Path);
    int x=Path.lastIndexOf("\\");
    int y=Path.lastIndexOf(".");
    String textf=Path.substring(x+1,y);
    path=path.replaceAll("\\\\\\\\", "\\\\");

    Object[] row = new Object[4];
    
    if(i<10){
        row[0] = ++i;
        row[1] = textf;
        row[2] = path;
        // add row to the model
        upn[i]=path;

        model.addRow(row);}
c++;

}

private void button1MouseClicked(MouseEvent e) {

System.out.println(c);
    for(i=1;i<=c;i++)
    {

        try {
            pa.Upload(upn[i]);
//            String fi=pa.encrypt(upn[i],Credentials.secret_access_key);
//             pa.aws_down(fi);
           // System.out.println(upn[i]);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    int rows = table1.getRowCount();
    for(int i=0;i<rows;i++)
        ((DefaultTableModel)table1.getModel()).removeRow(i);
}


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ryue
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        setBackground(Color.white);
        setTitle("Swasthya");
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

            //---- label2 ----
            label2.setText("         Click here to Select files");
            label2.setFont(new Font("Calibri", Font.PLAIN, 50));
            label2.setBorder(new CompoundBorder(
                UIManager.getBorder("List.focusCellHighlightBorder"),
                UIManager.getBorder("Table.focusCellHighlightBorder")));
            label2.setBackground(Color.cyan);
            label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            label2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label2MouseClicked(e);
                }
            });

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

            //---- button1 ----
            button1.setFont(new Font("Calibri", Font.PLAIN, 28));
            button1.setIcon(new ImageIcon("F:\\1P\\pathology\\img\\upb.gif"));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                .addGap(395, 395, 395))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(305, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - ryue
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

