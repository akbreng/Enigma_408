import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.TextArea;


public class Main {
	private Enigma enigma;
	private JFrame Welcome_Frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] arg) {
		
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
	 * @return 
	 */
	public void EnigmaGUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		enigma = new Enigma(); //adds enigma machine
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
		panel_2.setLayout(null);
		
		JLabel lblEncryptText = new JLabel("Encrypt text");
		lblEncryptText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEncryptText.setBounds(12, 13, 167, 16);
		panel_2.add(lblEncryptText);
		
		JLabel lblDecryptedText = new JLabel("Decrypted Text");
		lblDecryptedText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDecryptedText.setBounds(12, 233, 167, 16);
		panel_2.add(lblDecryptedText);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 39, 323, 137);
		panel_2.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(12, 268, 321, 137);
		panel_2.add(textArea_1);
		textArea_1.setEditable(false);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBackground(Color.CYAN);
		btnEncrypt.setBounds(215, 186, 97, 25);
		panel_2.add(btnEncrypt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(170, 280, 10, -59);
		Welcome_Frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Default Settings");
		btnNewButton.setLocation(124, 137);
		Welcome_Frame.getContentPane().add(btnNewButton);
		btnNewButton.setSize(151,25);
		btnNewButton.setBackground(Color.CYAN);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(58, 175, 273, 32);
		Welcome_Frame.getContentPane().add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Rotor 1");
		panel_4.add(lblNewLabel_1);
		
		String[] RotorList = {"I", "II", "III", "IV", "V"};
		String[] RotorStart = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		JComboBox<String> comboBox_1 = new JComboBox<>(RotorList);
		panel_4.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rotor 2");
		panel_4.add(lblNewLabel_2);
		
		JComboBox<String> comboBox = new JComboBox<>(RotorList);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Rotor 3");
		panel_4.add(lblNewLabel_3);
		
		JComboBox<String> comboBox_2 = new JComboBox<>(RotorList);
		panel_4.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(58, 254, 273, 32);
		Welcome_Frame.getContentPane().add(panel_5);
		
		JLabel label = new JLabel("Rotor 1");
		panel_5.add(label);
		
		JComboBox<String> comboBox_6 = new JComboBox<>(RotorStart);
		panel_5.add(comboBox_6);
		
		JLabel label_1 = new JLabel("Rotor 2");
		panel_5.add(label_1);
		
		JComboBox<String> comboBox_7 = new JComboBox<>(RotorStart);
		panel_5.add(comboBox_7);
		
		JLabel label_2 = new JLabel("Rotor 3");
		panel_5.add(label_2);
		
		JComboBox<String> comboBox_8 = new JComboBox<>(RotorStart);
		panel_5.add(comboBox_8);
		
		JLabel lblRotorPosition = new JLabel("Rotor Position");
		lblRotorPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotorPosition.setBounds(58, 230, 273, 21);
		Welcome_Frame.getContentPane().add(lblRotorPosition);
		
		JLabel lblPlugboard = new JLabel("Plugboard");
		lblPlugboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlugboard.setBounds(58, 299, 273, 25);
		Welcome_Frame.getContentPane().add(lblPlugboard);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(68, 337, 263, 336);
		Welcome_Frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 37, 27, 22);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblDesignateLetter = new JLabel("Designate 10 letter associations");
		lblDesignateLetter.setBounds(28, 8, 197, 16);
		panel_3.add(lblDesignateLetter);
		
		JLabel label_3 = new JLabel("=");
		label_3.setBounds(117, 40, 27, 16);
		panel_3.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 37, 27, 22);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPairedLetters = new JLabel("Paired Letters");
		lblPairedLetters.setBounds(78, 99, 86, 16);
		panel_3.add(lblPairedLetters);
		//Matched labels0
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(49, 128, 56, 16);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(135, 128, 56, 16);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(49, 178, 56, 16);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(135, 178, 56, 16);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(49, 157, 56, 16);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(135, 157, 56, 16);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(49, 207, 56, 16);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(135, 207, 56, 16);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(49, 236, 56, 16);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(135, 236, 56, 16);
		panel_3.add(lblNewLabel_13);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(67, 72, 109, 25);
		panel_3.add(btnNewButton_1);
		
		JButton btnResetAssociations = new JButton("Reset Associations");
		btnResetAssociations.setBounds(49, 265, 144, 25);
		panel_3.add(btnResetAssociations);
	}
}