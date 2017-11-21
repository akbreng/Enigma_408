import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.xml.internal.ws.api.Component;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.TextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class EnigmaGUI {
	public JComboBox<String> comboBox_1;
	public JComboBox<String> comboBox_2;
	public JComboBox<String> comboBox;
	public JComboBox<String> comboBox_6;
	public JComboBox<String> comboBox_7;
	public JComboBox<String> comboBox_8;
	public TextArea textArea_1;
	public TextArea textArea;
	private Enigma enigma;
	JFrame Welcome_Frame;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private int i = 0;
	private JLabel[] labels;
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void run() {
		
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
		enigma = new Enigma(); //adds enigma machine
		int x = 840, y = 750;   //x is width, y is height
		Welcome_Frame = new JFrame();
		Welcome_Frame.setBounds(0, 0, x, y);
		Welcome_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Welcome_Frame.getContentPane().setLayout(null);
		Welcome_Frame.setResizable(false);
		
		
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(45);
		flowLayout.setHgap(0);
		panel.setBounds(0, 0, x, y/5);
		Welcome_Frame.getContentPane().add(panel);
		
		//Title of the window
		JLabel lblNewLabel = new JLabel("Enigma Emulator");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		
		//-------------------------
		//output-input side of frame
		//-------------------------
		
		//panel for input and out put txt
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(417, 137, 343, 418);
		Welcome_Frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//input label for txt box
		JLabel lblEncryptText = new JLabel("Encrypt text");
		lblEncryptText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEncryptText.setBounds(12, 13, 167, 16);
		panel_2.add(lblEncryptText);
		
		//output label for txt box
		JLabel lblDecryptedText = new JLabel("Decrypted Text");
		lblDecryptedText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDecryptedText.setBounds(12, 233, 167, 16);
		panel_2.add(lblDecryptedText);
		
		//input txt box
		textArea = new TextArea();
		textArea.setBounds(10, 39, 323, 137);
		panel_2.add(textArea);
		
		//output txt box
		textArea_1 = new TextArea();
		textArea_1.setBounds(12, 268, 321, 137);
		panel_2.add(textArea_1);
		textArea_1.setEditable(false);
		
		//button to run text through enigma machine
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setAction(action);
		btnEncrypt.setBackground(Color.CYAN);
		btnEncrypt.setBounds(215, 186, 97, 25);
		panel_2.add(btnEncrypt);
		
		//--------------
		//Panel for default settings button
		//--------------
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(170, 280, 10, -59);
		Welcome_Frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Default Settings");
		btnNewButton.setAction(action_1);
		btnNewButton.setLocation(124, 137);
		Welcome_Frame.getContentPane().add(btnNewButton);
		btnNewButton.setSize(151,25);
		btnNewButton.setBackground(Color.CYAN);
		
		//--------------------
		//Panel for Rotor titles and Rotor positions
		//--------------------
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(58, 175, 273, 32);
		Welcome_Frame.getContentPane().add(panel_4);
		
		//far left rotor number label and comboBox
		JLabel lblNewLabel_1 = new JLabel("Rotor 1");
		panel_4.add(lblNewLabel_1);
		String[] RotorList = {"I", "II", "III", "IV", "V"};
		String[] RotorStart = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		comboBox_1 = new JComboBox(RotorList);
		panel_4.add(comboBox_1);
		comboBox_1.setSelectedIndex(enigma.getDisk(2));
		
		
		//far middle rotor number label and comboBox
		JLabel lblNewLabel_2 = new JLabel("Rotor 2");
		panel_4.add(lblNewLabel_2);
		
		comboBox = new JComboBox(RotorList);
		panel_4.add(comboBox);
		comboBox.setSelectedIndex(enigma.getDisk(1));
		
		//far right rotor number label and comboBox
		JLabel lblNewLabel_3 = new JLabel("Rotor 3");
		panel_4.add(lblNewLabel_3);
		
		comboBox_2 = new JComboBox(RotorList);
		panel_4.add(comboBox_2);
		comboBox_2.setSelectedIndex(enigma.getDisk(0));
		
		//--------------
		//Panel for rotor positions and labels
		//--------------
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(58, 254, 273, 32);
		Welcome_Frame.getContentPane().add(panel_5);
		
		JLabel label = new JLabel("Rotor 1");
		panel_5.add(label);
		
		comboBox_6 = new JComboBox(RotorStart);
		panel_5.add(comboBox_6);
		comboBox_6.setSelectedIndex(enigma.getPosition(0));
		
		JLabel label_1 = new JLabel("Rotor 2");
		panel_5.add(label_1);
		
		comboBox_7 = new JComboBox(RotorStart);
		panel_5.add(comboBox_7);
		comboBox_7.setSelectedIndex(enigma.getPosition(1));
		
		JLabel label_2 = new JLabel("Rotor 3");
		panel_5.add(label_2);
		
		comboBox_8 = new JComboBox(RotorStart);
		panel_5.add(comboBox_8);
		comboBox_8.setSelectedIndex(enigma.getPosition(2));
		
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
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setBounds(49, 130, 56, 16);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("2");
		lblNewLabel_5.setBounds(135, 130, 56, 16);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("3");
		lblNewLabel_6.setBounds(49, 152, 56, 16);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("4");
		lblNewLabel_7.setBounds(135, 152, 56, 16);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("5");
		lblNewLabel_8.setBounds(49, 174, 56, 16);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("6");
		lblNewLabel_9.setBounds(135, 174, 56, 16);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("7");
		lblNewLabel_10.setBounds(49, 196, 56, 16);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("8");
		lblNewLabel_11.setBounds(135, 196, 56, 16);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("9");
		lblNewLabel_12.setBounds(49, 218, 56, 16);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("10");
		lblNewLabel_13.setBounds(135, 218, 56, 16);
		panel_3.add(lblNewLabel_13);
		
		labels = new JLabel[] {lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7
				, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12, lblNewLabel_13};
		
		int aa = 0;
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setAction(action_2);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(67, 72, 109, 25);
		panel_3.add(btnNewButton_1);
		
		JButton btnResetAssociations = new JButton("Reset Associations");
		btnResetAssociations.setAction(action_3);
		btnResetAssociations.setBounds(49, 265, 144, 25);
		panel_3.add(btnResetAssociations);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(609, 559, 151, 131);
		Welcome_Frame.getContentPane().add(panel_6);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("SnapCode.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel_6.add(picLabel);
		
		
		
	};
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Encrypt");
			putValue(SHORT_DESCRIPTION, "Encrypt the input");
		}
		public void actionPerformed(ActionEvent e) {
			enigma.setDisk(0, comboBox_1.getSelectedIndex(), comboBox_6.getSelectedIndex());
			enigma.setDisk(1, comboBox.getSelectedIndex(), comboBox_7.getSelectedIndex());
			enigma.setDisk(2, comboBox_2.getSelectedIndex(), comboBox_8.getSelectedIndex());
			
			textArea_1.setText(enigma.Encrypt(textArea.getText().toUpperCase()));
			enigma.fillPlugboard();
			System.out.println(enigma.getPlugboard());
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Default Settings");
			putValue(SHORT_DESCRIPTION, "Reset settings to their default values");
		}
		public void actionPerformed(ActionEvent e) {
			comboBox_1.setSelectedIndex(0);
			comboBox.setSelectedIndex(1);
			comboBox_2.setSelectedIndex(2);
			comboBox_6.setSelectedIndex(0);
			comboBox_7.setSelectedIndex(0);
			comboBox_8.setSelectedIndex(0);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Submit your letter designation");
		}
		public void actionPerformed(ActionEvent e) {
			if(i == 0)
				enigma.resetPlugboard();
			char a = textField.getText().toUpperCase().charAt(0);
			char b = textField_1.getText().toUpperCase().charAt(0);
			if(enigma.checkPair(a, b) == true && i < 10)
			{
				enigma.customizePlugboard(a, b);
				labels[i].setText(a + " = " + b);
				i++;
			}
			}
			
		}
	
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Reset Plugboard");
			putValue(SHORT_DESCRIPTION, "Resets the plugboard associations");
		}
		public void actionPerformed(ActionEvent e) {
			enigma.resetPlugboard();
			for(int i = 0; i < 10; i++)
			{
				labels[i].setText(Integer.toString(i+1));
				i++;
			}
		}
	}
	}

