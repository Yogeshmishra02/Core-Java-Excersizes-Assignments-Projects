package GUI.SMS;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;

public class StudentData extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSerialNo;
    private JTextField textFieldName;
    private JTextField textFieldClass;
    private JTextField textFieldBatchName;
    private JTextField textFieldPaymentDate;
    private JTextField textFieldMobile;
    private JTextField textFieldParentsMobile;
    private JTextField textFieldPayAmount;
    private JTable table;
    private JTextField textFieldSearchName;

    // Data for the table
    private List<String> students = new ArrayList<>();
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	StudentData frame = new StudentData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StudentData() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1088, 660);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(224, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(175, 238, 238));
        panel.setBounds(12, 66, 298, 490);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblManageStudents = new JLabel ("Manage Student's Data");
        lblManageStudents.setFont(new Font(" Tahoma", Font.BOLD, 16));
        lblManageStudents.setBounds(78, 0, 183, 29);
        panel.add(lblManageStudents);

        JLabel lblSerialNo = new JLabel("Serial No:");
        lblSerialNo.setBounds(10, 149, 104, 14);
        panel.add(lblSerialNo);

        textFieldSerialNo = new JTextField();
        textFieldSerialNo.setBounds(124, 147, 137, 20);
        panel.add(textFieldSerialNo);
        textFieldSerialNo.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(10, 179, 104, 14);
        panel.add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(124, 177, 137, 20);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblClass = new JLabel("Class:");
        lblClass.setBounds(10, 209, 104, 14);
        panel.add(lblClass);

        textFieldClass = new JTextField();
        textFieldClass.setBounds(124, 207, 137, 20);
        panel.add(textFieldClass);
        textFieldClass.setColumns(10);

        JLabel lblBatchName = new JLabel("Batch Name:");
        lblBatchName.setBounds(10, 239, 104, 14);
        panel.add(lblBatchName);

        textFieldBatchName = new JTextField();
        textFieldBatchName.setBounds(124, 237, 137, 20);
        panel.add(textFieldBatchName);
        textFieldBatchName.setColumns(10);

        JLabel lblPaymentDate = new JLabel("Payment Date:");
        lblPaymentDate.setBounds(10, 266, 104, 14);
        panel.add(lblPaymentDate);

        textFieldPaymentDate = new JTextField();
        textFieldPaymentDate.setBounds(124, 264, 137, 20);
        panel.add(textFieldPaymentDate);
        textFieldPaymentDate.setColumns(10);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setBounds(10, 296, 104, 14);
        panel.add(lblMobile);

        textFieldMobile = new JTextField();
        textFieldMobile.setBounds(124, 294, 137, 20);
        panel.add(textFieldMobile);
        textFieldMobile.setColumns(10);

        JLabel lblParentsMobile = new JLabel("Parents Mobile:");
        lblParentsMobile.setBounds(10, 324, 104, 14);
        panel.add(lblParentsMobile);

        textFieldParentsMobile = new JTextField();
        textFieldParentsMobile.setBounds(124, 322, 137, 20);
        panel.add(textFieldParentsMobile);
        textFieldParentsMobile.setColumns(10);

        JLabel lblPayAmount = new JLabel("Pay Amount:");
        lblPayAmount.setBounds(10, 358, 104, 14);
        panel.add(lblPayAmount);

        textFieldPayAmount = new JTextField();
        textFieldPayAmount.setBounds(124, 352, 137, 20);
        panel.add(textFieldPayAmount);
        textFieldPayAmount.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(10, 396, 89, 23);
        panel.add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(109, 396, 89, 23);
        panel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(208, 396, 89, 23);
        panel.add(btnDelete);
        
                JLabel lblSearchByName = new JLabel("Search By Name:");
                lblSearchByName.setBounds(10, 440, 109, 14);
                panel.add(lblSearchByName);
                
                        textFieldSearchName = new JTextField();
                        textFieldSearchName.setBounds(109, 438, 86, 20);
                        panel.add(textFieldSearchName);
                        textFieldSearchName.setColumns(10);
                        
                                JButton btnSearch = new JButton("Search");
                                btnSearch.setBounds(208, 436, 89, 23);
                                panel.add(btnSearch);
                                
                                JLabel image = new JLabel("");
                                image.setBounds(78, 27, 120, 112);
                                image.setIcon(new ImageIcon("Image/profile.png"));
                                panel.add(image);

                                // Resize the image
                                int labelWidth = image.getWidth();
                                int labelHeight = image.getHeight();
                                Image img = new ImageIcon("Image/profile.png").getImage();
                                Image newImage = img.getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH);
                                ImageIcon newIcon = new ImageIcon(newImage);
                                image.setIcon(newIcon);
                                
                                        btnSearch.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                // Search button action
                                            }
                                        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(320, 107, 730, 449);
        contentPane.add(scrollPane);

        tableModel = new DefaultTableModel(new Object[]{"Serial No", "Name", "Class", "Batch Name", "Payment Date", "Mobile", "Parents Mobile", "Pay Amount"}, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
        
                JButton btnShowAll = new JButton("Show All");
                btnShowAll.setBounds(330, 66, 89, 23);
                contentPane.add(btnShowAll);
                
                        JButton btnClear = new JButton("Clear");
                        btnClear.setBounds(443, 66, 89, 23);
                        contentPane.add(btnClear);
                        
                        JPanel panel_1 = new JPanel();
                        panel_1.setBackground(new Color(0, 0, 255));
                        panel_1.setBounds(0, 0, 1072, 46);
                        contentPane.add(panel_1);
                        
                        JLabel lblStudentsManagementSystem = new JLabel("Students Management System  ");
                        panel_1.add(lblStudentsManagementSystem);
                        lblStudentsManagementSystem.setForeground(Color.BLACK);
                        lblStudentsManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
                        lblStudentsManagementSystem.setBackground(new Color(0, 0, 205));
                        
                        JPanel panel_1_1 = new JPanel();
                        panel_1_1.setBackground(Color.BLUE);
                        panel_1_1.setBounds(0, 575, 1072, 46);
                        contentPane.add(panel_1_1);
                        
                        JLabel lblDevelopedByShalini = new JLabel("Developed By Shalini Verma  ");
                        lblDevelopedByShalini.setForeground(Color.BLACK);
                        lblDevelopedByShalini.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        lblDevelopedByShalini.setBackground(new Color(0, 0, 205));
                        panel_1_1.add(lblDevelopedByShalini);
                        
                                btnClear.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        // Clear button action
                                    }
                                });
                
                        btnShowAll.addActionListener (new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Show All button action
                            }
                        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add button action
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update button action
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete button action
            }
        });
    }
}
StudentData.java
Displaying StudentData.java.