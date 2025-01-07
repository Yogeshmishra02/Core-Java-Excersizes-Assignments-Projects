package GUI.SMS;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer; 

public class Splash_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static Splash_Screen frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						frame = new Splash_Screen();
						frame.addWindowListener(new WindowAdapter() {
	                         @Override
	                        public void windowOpened(WindowEvent e) {
	                            frame = (Splash_Screen) e.getWindow();
	                            frame.setSize(1088, 660); // set the window size to 800x600
	                        }
	                    });
						frame.setVisible(true);
					// launch another screen for some time
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
public Splash_Screen() {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 660);
        setMinimumSize(new Dimension(1088, 660)); // Setting minimum size
        setMaximumSize(new Dimension(1088, 660)); // Setting maximum size
        setResizable(false);
        setLocationRelativeTo(null); // center the screen in Eclipse
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		
		
		setUndecorated(true);

		Timer timer = new Timer(8000, new ActionListener() { 
		    @Override
		    public void actionPerformed(ActionEvent e) { 
		        frame.dispose(); 
		        SwingUtilities.invokeLater(() -> new Login().setVisible(true)); 
		        // opens the HistoryEditor page
		        ((Timer)e.getSource()).stop(); // stop the timer
		    }
		});
		timer.setRepeats(false); // set the timer to fire only once
		timer.start();
        contentPane.setLayout(null);

		
		 // Create the logo and "LOGIN" text
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("Image/Student.png")); // Replace "logo.png" with your actual logo image
        logo.setBounds(-57, 0, 1163, 660);
        contentPane.add(logo);
        
        // Resize the image
        int labelWidth = logo.getWidth();
        int labelHeight = logo.getHeight();
        Image img = new ImageIcon("Image/Student.png").getImage();
        Image newImage = img.getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);
        logo.setIcon(newIcon);
		
	}
}
Splash_Screen.java
Displaying Splash_Screen.java.