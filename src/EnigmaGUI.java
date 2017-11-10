import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class EnigmaGUI {

	private JFrame Welcome_Frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaGUI window = new EnigmaGUI();
					window.Welcome_Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnigmaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int x = 800, y = 750;   //x is width, y is height
		Welcome_Frame = new JFrame();
		Welcome_Frame.setBounds(0, 0, x+20, y);
		Welcome_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Welcome_Frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(45);
		flowLayout.setHgap(0);
		panel.setBounds(0, 0, 800, 102);
		Welcome_Frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Enigma Emulator");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(417, 137, 343, 459);
		Welcome_Frame.getContentPane().add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(170, 280, 10, -59);
		Welcome_Frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(40, 137, 334, 459);
		Welcome_Frame.getContentPane().add(panel_3);
		
		JButton btnNewButton = new JButton("Default Settings");
		panel_3.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 191, 255));
		Welcome_Frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, lblNewLabel, panel_2, btnNewButton, panel_1}));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
	}
}
