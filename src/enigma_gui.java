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

public class enigma_gui {

	private JFrame Welcome_Frame;
	private JTextField txtWelcomeToEnigma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enigma_gui window = new enigma_gui();
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
	public enigma_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Welcome_Frame = new JFrame();
		Welcome_Frame.setBounds(100, 100, 450, 300);
		Welcome_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton default_Settings = new JButton("Default settings");
		default_Settings.setToolTipText("Use the preset configuration");
		default_Settings.setBackground(Color.CYAN);
		default_Settings.setHorizontalAlignment(SwingConstants.LEFT);
		default_Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Welcome_Frame.getContentPane().add(default_Settings, BorderLayout.WEST);
		
		txtWelcomeToEnigma = new JTextField();
		txtWelcomeToEnigma.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtWelcomeToEnigma.setText("Welcome to Enigma Emulator!");
		Welcome_Frame.getContentPane().add(txtWelcomeToEnigma, BorderLayout.CENTER);
		txtWelcomeToEnigma.setColumns(10);
		
		JButton btnCustumSettings = new JButton("Custum Settings");
		btnCustumSettings.setSize(50,50);
		btnCustumSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustumSettings.setToolTipText("Edit the Settings");
		Welcome_Frame.getContentPane().add(btnCustumSettings, BorderLayout.EAST);
	}

}
