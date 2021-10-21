import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tietoja extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnSulje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tietoja frame = new Tietoja();
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
	public Tietoja() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 272, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Bensis for Desktop");
		lblNewLabel.setBounds(63, 27, 146, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Copyright © 2021 Anne Ruohonen");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(21, 70, 229, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("version 1.5.14");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(81, 95, 109, 15);
		contentPane.add(lblNewLabel_1);
		
		btnSulje = new JButton("Sulje");
		btnSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tietoja.this.setVisible(false);
			}
		});
		btnSulje.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnSulje.setBounds(84, 155, 92, 25);
		contentPane.add(btnSulje);
	}
}
