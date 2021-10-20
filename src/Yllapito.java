import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Yllapito extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnHinnat;
	private JButton btnTankit;
	private JButton btnAsemalle;
	private JMenuBar menuBar;
	private JMenu mnTiedosto;
	private JMenuItem mntmOhje;
	private JMenuItem mntmTietoja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yllapito frame = new Yllapito();
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
	public Yllapito() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Yllapito.class.getResource("/Img/gas-truck.png")));
		setTitle("Ylläpito");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 590, 476);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		mntmOhje = new JMenuItem("Ohje");
		mnTiedosto.add(mntmOhje);
		
		mntmTietoja = new JMenuItem("Tietoja");
		mnTiedosto.add(mntmTietoja);
		
		contentPane = new JPanel() {
		public void paintComponent(Graphics g) {  
			 Image img = Toolkit.getDefaultToolkit().getImage(  
					 Yllapito.class.getResource("Img/gas-truck.jpg"));  
			 g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			 }  
		};  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ylläpito");
		lblNewLabel.setBounds(196, 24, 199, 22);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		btnHinnat = new JButton("Hinnat");
		btnHinnat.setBounds(118, 90, 117, 68);
		contentPane.add(btnHinnat);
		
		btnTankit = new JButton("Tankit");
		btnTankit.setBounds(353, 90, 117, 68);
		contentPane.add(btnTankit);
		
		btnAsemalle = new JButton("Asemalle");
		btnAsemalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yllapito.this.setVisible(false);
		
			}
		});
		btnAsemalle.setBounds(461, 381, 117, 25);
		contentPane.add(btnAsemalle);
	}
}
