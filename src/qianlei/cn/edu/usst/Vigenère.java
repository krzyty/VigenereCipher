package qianlei.cn.edu.usst;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Vigenère {

	private JFrame frmCaesarCipherBy;
	public static String plainText;
	public static char[] plainCh;
	public static String enText;
	public static char[] enCh;
	public static String deText;
	public static char[] deCh;
	public static String key;
	public static char[] keyCh;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vigenère window = new Vigenère();
					window.frmCaesarCipherBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vigenère() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCaesarCipherBy = new JFrame();
		frmCaesarCipherBy.setTitle("Vigenère Cipher by Ray Chien");
		frmCaesarCipherBy.setBounds(100, 100, 450, 300);
		frmCaesarCipherBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("输入明文");
		
        JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		
		JTextArea textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("输入密钥");
		
		JLabel label_1 = new JLabel("密文");
		
		
		JLabel label_2 = new JLabel("解密");
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plainText =textArea.getText();
				plainCh=plainText.toCharArray();
				if(textField.getText().trim().equals("")||textField.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null,"Please input an key!","Info:",JOptionPane.QUESTION_MESSAGE);
				}
				String str = textField.getText();
				Pattern pattern = Pattern.compile("[a-zA-Z]+");
				if(!pattern.matcher(str).matches()||str==""||str==null)
				{
					JOptionPane.showMessageDialog(null,"Please input an legle key!","Info:",JOptionPane.QUESTION_MESSAGE);
				}
				key=str;
				keyCh=key.toCharArray();
				for (int i = 0; i < plainCh.length; i++) {
					if(plainCh[i]>='a'&&plainCh[i]<='z')
					{
						plainCh[i]=(char) ((plainCh[i]+keyCh[i%keyCh.length]-97)%26+97);
					}
					else if(plainCh[i]>='A'&&plainCh[i]<='Z')
					{
						plainCh[i]=(char) ((plainCh[i]+keyCh[i%keyCh.length]-65)%26+65);
					}
				}
			    enText = String.valueOf(plainCh);
			    textArea_2.setText(enText);
			    enCh=enText.toCharArray();
			    for (int i = 0; i < enCh.length; i++) {
					if(enCh[i]>='a'&&enCh[i]<='z')
					{
						enCh[i]=(char) ((enCh[i]+(26-keyCh[i%keyCh.length]%26)-97)%26+97);
					}
					else if(enCh[i]>='A'&&enCh[i]<='Z')
					{
						enCh[i]=(char) ((enCh[i]+(26-keyCh[i%keyCh.length]%26)-65)%26+65);
					}
				}
			    deText = String.valueOf(enCh);
			    textArea_3.setText(deText);
			}
		});
		
		
				
		GroupLayout groupLayout = new GroupLayout(frmCaesarCipherBy.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(30)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(45)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(scrollPane_1)
						.addComponent(scrollPane_2, Alignment.LEADING))
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(15)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
					.addContainerGap())
		);
		frmCaesarCipherBy.getContentPane().setLayout(groupLayout);
	}
}
