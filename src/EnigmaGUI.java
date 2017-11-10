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
import javax.swing.JComboBox;

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
		
		JButton btnNewButton = new JButton("Default Settings");
		btnNewButton.setLocation(133, 137);
		Welcome_Frame.getContentPane().add(btnNewButton);
		btnNewButton.setSize(123,25);
		btnNewButton.setBackground(new Color(0, 191, 255));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(58, 175, 273, 32);
		Welcome_Frame.getContentPane().add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Rotor 1");
		panel_4.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rotor 2");
		panel_4.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Rotor 3");
		panel_4.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_4.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(58, 254, 273, 32);
		Welcome_Frame.getContentPane().add(panel_5);
		
		JLabel label = new JLabel("Rotor 1");
		panel_5.add(label);
		
		JComboBox comboBox_6 = new JComboBox();
		panel_5.add(comboBox_6);
		
		JLabel label_1 = new JLabel("Rotor 2");
		panel_5.add(label_1);
		
		JComboBox comboBox_7 = new JComboBox();
		panel_5.add(comboBox_7);
		
		JLabel label_2 = new JLabel("Rotor 3");
		panel_5.add(label_2);
		
		JComboBox comboBox_8 = new JComboBox();
		panel_5.add(comboBox_8);
		
		JLabel lblRotorPosition = new JLabel("Rotor Position");
		lblRotorPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotorPosition.setBounds(58, 230, 273, 21);
		Welcome_Frame.getContentPane().add(lblRotorPosition);
		
		JLabel lblPlugboard = new JLabel("Plugboard");
		lblPlugboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlugboard.setBounds(58, 299, 273, 25);
		Welcome_Frame.getContentPane().add(lblPlugboard);
		Welcome_Frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, lblNewLabel, panel_2, btnNewButton, panel_1}));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
	}
}
