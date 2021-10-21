import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ohjeikkuna extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAsema;
	private JMenu mnHintojenYllpito;
	private JMenu mnTankkienYllpito;
	private JMenu mnTiedosto;
	private JMenuItem mntmSulje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ohjeikkuna frame = new Ohjeikkuna();
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
	public Ohjeikkuna() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 540, 446);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		mntmSulje = new JMenuItem("Sulje");
		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ohjeikkuna.this.setVisible(false);
			}
		});
		mnTiedosto.add(mntmSulje);
		
		mnAsema = new JMenu("Asema");
		menuBar.add(mnAsema);
		
		mnHintojenYllpito = new JMenu("Hintojen ylläpito");
		menuBar.add(mnHintojenYllpito);
		
		mnTankkienYllpito = new JMenu("Tankkien ylläpito");
		menuBar.add(mnTankkienYllpito);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
