import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import javax.swing.UIManager; 

public class Automaatti extends JFrame {

	private JPanel contentPane;
	private JPanel panel_95;
	private JLabel label_95;
	private JPanel panel_price95;
	private JLabel label_price95;
	private JPanel panel_98;
	private JLabel label_98;
	private JPanel panel_price98;
	private JLabel label_price98;
	private JRadioButton rdbtn95;
	private JRadioButton rdbtn98;
	private JPasswordField txtPinkoodi;
	private JLabel lblTankattava;
	private JLabel lblMaara;
	private JLabel lblPinkoodi;
	private JLabel lblLitraa;
	private JLabel lblHinta;
	private JLabel lblTarjous;
	private JButton btnTankkaa;
	private JLabel label_tarjous;
	private JButton btnAdmin;
	private JSlider slider;
	private JLabel textField_litrat;
	private JLabel lblEurot;
	private JLabel lblValuutta;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonCancel;
	private JButton button0;
	private JButton buttonBack;
	
	private Salasanaikkuna salasanaIkkuna = new Salasanaikkuna();
	
	String hinta95;
	String hinta98;
	String tarjous;
	String pinInput = "";
	int tankki95;
	int tankki98;
	double maksu;
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	String filenameHinnat = "src/Resources/hinnat.txt";
	String filenameTarjous = "src/Resources/tarjous.txt";
	String filenameTankit = "src/Resources/tankit.txt";
	String filenameOstokset = "src/Resources/ostokset.txt";

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Automaatti frame = new Automaatti();
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
	public Automaatti() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Automaatti.class.getResource("/Img/gas-pump.png")));
		setTitle("BENSIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 552);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {  
				 Image img = Toolkit.getDefaultToolkit().getImage(  
						 Automaatti.class.getResource("Img/gas-station.jpg"));  
				 g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
				 }  
		};  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BENSAMITTARI
		lblHinta = new JLabel("Polttoainehinnat");
		lblHinta.setForeground(Color.BLACK);
		lblHinta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHinta.setBounds(40, 11, 170, 15);
		contentPane.add(lblHinta);
		
		panel_95 = new JPanel();
		panel_95.setBackground(new Color(220, 220, 220));
		panel_95.setBounds(37, 40, 64, 45);
		contentPane.add(panel_95);
		panel_95.setLayout(null);
		
		label_95 = new JLabel("95");
		label_95.setBounds(6, 10, 52, 25);
		panel_95.add(label_95);
		label_95.setHorizontalAlignment(SwingConstants.CENTER);
		label_95.setFont(new Font("Dialog", Font.BOLD, 17));
		
		panel_price95 = new JPanel();
		panel_price95.setLayout(null);
		panel_price95.setBackground(new Color(220, 220, 220));
		panel_price95.setBounds(109, 40, 101, 45);
		contentPane.add(panel_price95);
		
		label_price95 = new JLabel("<dynamic>");
		label_price95.setHorizontalAlignment(SwingConstants.CENTER);
		label_price95.setFont(new Font("Dialog", Font.BOLD, 17));
		label_price95.setBounds(12, 10, 77, 25);
		panel_price95.add(label_price95);
		
		panel_98 = new JPanel();
		panel_98.setLayout(null);
		panel_98.setBackground(new Color(220, 220, 220));
		panel_98.setBounds(37, 91, 64, 45);
		contentPane.add(panel_98);
		
		label_98 = new JLabel("98");
		label_98.setHorizontalAlignment(SwingConstants.CENTER);
		label_98.setFont(new Font("Dialog", Font.BOLD, 17));
		label_98.setBounds(6, 10, 52, 25);
		panel_98.add(label_98);
		
		panel_price98 = new JPanel();
		panel_price98.setLayout(null);
		panel_price98.setBackground(new Color(220, 220, 220));
		panel_price98.setBounds(109, 91, 101, 45);
		contentPane.add(panel_price98);
		
		label_price98 = new JLabel("<dynamic>");
		label_price98.setHorizontalAlignment(SwingConstants.CENTER);
		label_price98.setFont(new Font("Dialog", Font.BOLD, 17));
		label_price98.setBounds(12, 10, 77, 25);
		panel_price98.add(label_price98);
		
		// PÄIVÄN TARJOUS
		lblTarjous = new JLabel("Päivän tarjous");
		lblTarjous.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTarjous.setBounds(40, 189, 148, 23);
		contentPane.add(lblTarjous);
		
		label_tarjous = new JLabel("<dynamic>");
		label_tarjous.setBounds(40, 208, 428, 45);
		contentPane.add(label_tarjous);
		label_tarjous.setHorizontalAlignment(SwingConstants.LEFT);
		label_tarjous.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		// AUTOMAATTI
		// Polttoaineen valinta
		lblTankattava = new JLabel("Valitse polttoaine");
		lblTankattava.setBounds(588, 12, 148, 15);
		contentPane.add(lblTankattava);
		
		rdbtn95 = new JRadioButton("95");
		rdbtn95.setSelected(true);
		rdbtn95.setBounds(588, 34, 51, 23);
		contentPane.add(rdbtn95);
		
		rdbtn98 = new JRadioButton("98");
		rdbtn98.setBounds(588, 66, 51, 23);
		contentPane.add(rdbtn98);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtn95);
		group.add(rdbtn98);
		
		// Tankattavan määrän valinta
		lblMaara = new JLabel("Tankattava määrä");
		lblMaara.setBounds(588, 112, 172, 15);
		contentPane.add(lblMaara);
		
		slider = new JSlider();
		slider.setValue(20);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField_litrat.setText("" + slider.getValue());
				if (rdbtn95.isSelected()) {
					maksu = slider.getValue() * Double.parseDouble(label_price95.getText());
					lblEurot.setText(String.valueOf(df.format(maksu)));
				} else if (rdbtn98.isSelected()) {
					maksu = slider.getValue() * Double.parseDouble(label_price98.getText());
					lblEurot.setText(String.valueOf(df.format(maksu)));
				}
			}
		});
		slider.setBounds(588, 139, 134, 16);
		contentPane.add(slider);
		
		textField_litrat = new JLabel();
		textField_litrat.setText("20");
		textField_litrat.setBounds(588, 167, 37, 19);
		contentPane.add(textField_litrat);

		
		lblLitraa = new JLabel("litraa");
		lblLitraa.setBounds(637, 169, 64, 15);
		contentPane.add(lblLitraa);
		
		lblEurot = new JLabel("");
		lblEurot.setBounds(588, 197, 51, 15);
		lblEurot.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblEurot);
		
		lblValuutta = new JLabel("€");
		lblValuutta.setBounds(637, 197, 31, 15);
		contentPane.add(lblValuutta);
		
		
		// Syötetään pankkikortin pin-koodi
		button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "1";
				txtPinkoodi.setText(pinInput);
			}
		});
		button1.setFont(new Font("Dialog", Font.BOLD, 12));
		button1.setBounds(588, 292, 51, 37);
		contentPane.add(button1);
		
		button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "2";
				txtPinkoodi.setText(pinInput);
			}
		});
		button2.setFont(new Font("Dialog", Font.BOLD, 12));
		button2.setBounds(640, 292, 51, 37);
		contentPane.add(button2);
		
		button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "3";
				txtPinkoodi.setText(pinInput);
			}
		});
		button3.setFont(new Font("Dialog", Font.BOLD, 12));
		button3.setBounds(692, 292, 51, 37);
		contentPane.add(button3);
		
		button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "4";
				txtPinkoodi.setText(pinInput);
			}
		});
		button4.setFont(new Font("Dialog", Font.BOLD, 12));
		button4.setBounds(588, 330, 51, 37);
		contentPane.add(button4);
		
		button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "5";
				txtPinkoodi.setText(pinInput);
			}
		});
		button5.setFont(new Font("Dialog", Font.BOLD, 12));
		button5.setBounds(640, 330, 51, 37);
		contentPane.add(button5);
		
		button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "6";
				txtPinkoodi.setText(pinInput);
			}
		});
		button6.setFont(new Font("Dialog", Font.BOLD, 12));
		button6.setBounds(692, 330, 51, 37);
		contentPane.add(button6);
		
		button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "7";
				txtPinkoodi.setText(pinInput);
			}
		});
		button7.setFont(new Font("Dialog", Font.BOLD, 12));
		button7.setBounds(588, 368, 51, 37);
		contentPane.add(button7);
		
		button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "8";
				txtPinkoodi.setText(pinInput);
			}
		});
		button8.setFont(new Font("Dialog", Font.BOLD, 12));
		button8.setBounds(640, 368, 51, 37);
		contentPane.add(button8);
		
		button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "9";
				txtPinkoodi.setText(pinInput);
			}
		});
		button9.setFont(new Font("Dialog", Font.BOLD, 12));
		button9.setBounds(692, 368, 51, 37);
		contentPane.add(button9);
		
		buttonCancel = new JButton("X");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tankkaus keskeytetty");
				pinInput = "";
				txtPinkoodi.setText(pinInput);
				slider.setValue(20);
				textField_litrat.setText("20");
				maksu = slider.getValue() * Double.parseDouble(label_price95.getText());
				lblEurot.setText(String.valueOf(df.format(maksu)));
			}
		});
		buttonCancel.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonCancel.setBounds(588, 406, 51, 37);
		contentPane.add(buttonCancel);
		
		button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput + "0";
				txtPinkoodi.setText(pinInput);
			}
		});
		button0.setFont(new Font("Dialog", Font.BOLD, 12));
		button0.setBounds(640, 406, 51, 37);
		contentPane.add(button0);
		
		buttonBack = new JButton("◄");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinInput = pinInput.substring(0, pinInput.length() - 1);
				txtPinkoodi.setText(pinInput);
			}
		});
		buttonBack.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonBack.setBounds(692, 406, 51, 37);
		contentPane.add(buttonBack);
		
		lblPinkoodi = new JLabel("Syötä pin-koodi");
		lblPinkoodi.setBounds(587, 235, 120, 15);
		contentPane.add(lblPinkoodi);
		
		// limit the number of characters  !!!!!!!!
		txtPinkoodi = new JPasswordField();
		txtPinkoodi.setBounds(588, 262, 52, 19);
		contentPane.add(txtPinkoodi);
		txtPinkoodi.setColumns(10);
		
		btnTankkaa = new JButton("TANKKAA");
		btnTankkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { //kryptataan pin
					String oikea_pin = crypt("1234");
					String pin_crypted = "";
					String choice = "";
					
					try {
						pin_crypted = crypt(txtPinkoodi.getText());
					} catch (Exception e2) {
						
					}
					//Tarkistetaan pin
					if (oikea_pin.equals(pin_crypted)) { 
						
						int result = JOptionPane.showConfirmDialog(null, "Vahvista tankkaus","", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if( result == JOptionPane.OK_OPTION ) {
							
							String txtTankit;
							String tankkaus = textField_litrat.getText();
							int vahennys = Integer.parseInt(tankkaus);
							tarkistaTankit(filenameTankit);
															
							if (rdbtn95.isSelected()) {
								tankki95 = tankki95 - vahennys;
								choice = "95";
								txtTankit  = "tankki95 = " + tankki95 + "\ntankki98 = " + tankki98;
								paivitaTankit(txtTankit);
								tallennaOstokset("Polttoaine 95: " + tankkaus + " litraa, " + df.format(vahennys) + " euroa.");
								
								
							} else if (rdbtn98.isSelected()) {
								tankki98 = tankki98 - vahennys;
								choice = "98";
								txtTankit = "tankki95 = " + tankki95 + "\ntankki98 = " + tankki98;
								paivitaTankit(txtTankit);
								tallennaOstokset("Polttoaine 98: " + tankkaus + " litraa, " + df.format(maksu) + " euroa.");
								
							}
							int kuitti = JOptionPane.showConfirmDialog(null, "Haluatko tulostaa kuitin?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if( kuitti == JOptionPane.OK_OPTION ) {
								java.util.Date datekuitti = new java.util.Date();
								JOptionPane.showMessageDialog(null, datekuitti.toString() + "\n\nPolttoaine: " + choice + "\nMäärä: " + tankkaus + " litraa\nVeloitus: " 
								+ df.format(maksu) + " euroa\nMaksettu luottokortilla.\n\nKiitos käynnistä ja tervetuloa uudelleen!");
							}
							if( kuitti == JOptionPane.NO_OPTION ) {
								JOptionPane.showMessageDialog(null, "Kiitos käynnistä ja tervetuloa uudelleen!");
							}
							
							slider.setValue(20);
							textField_litrat.setText("20");
							txtPinkoodi.setText("");
							maksu = slider.getValue() * Double.parseDouble(label_price95.getText());
							lblEurot.setText(String.valueOf(df.format(maksu)));
						}
							
						if( result == JOptionPane.NO_OPTION ) {
							JOptionPane.showMessageDialog(null, "Tankkaus keskeytetty");
							slider.setValue(20);
							textField_litrat.setText("20");
							txtPinkoodi.setText("");
							maksu = slider.getValue() * Double.parseDouble(label_price95.getText());
							lblEurot.setText(String.valueOf(df.format(maksu)));
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Väärä pin");
						txtPinkoodi.setText("");
						pinInput = "";
					}
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Virheellinen syöte");
				}	
			}

			
		});
		btnTankkaa.setBounds(598, 466, 117, 25);
		contentPane.add(btnTankkaa);
		
		
		// ADMIN
		btnAdmin = new JButton("Ylläpito");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salasanaIkkuna.dispose();
				salasanaIkkuna = new Salasanaikkuna();
				salasanaIkkuna.setVisible(true);
			}
		});
		btnAdmin.setBounds(40, 466, 117, 25);
		contentPane.add(btnAdmin);
		
		
		// FUNCTIONS
		lueHinnat(filenameHinnat);
		naytaTarjous(filenameTarjous);
		maksu = slider.getValue() * Double.parseDouble(label_price95.getText());
		lblEurot.setText(String.valueOf(df.format(maksu)));
		
	}
	
	public void lueHinnat(String filenameHinnat) {
			
		try {
			FileReader freader = new FileReader(filenameHinnat);
			BufferedReader br = new BufferedReader(freader);
			hinta95 = kasitteleRivi(br.readLine());
			hinta98 = kasitteleRivi(br.readLine());
				
			label_price95.setText(hinta95);
			label_price98.setText(hinta98);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void naytaTarjous(String filenameTarjous) {
		try {
			FileReader freader = new FileReader(filenameTarjous);
			BufferedReader br = new BufferedReader(freader);
			tarjous = br.readLine();
			label_tarjous.setText(tarjous);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tarkistaTankit(String txtTankit) {
		try {
			FileReader freader = new FileReader(filenameTankit);
			BufferedReader br = new BufferedReader(freader);
			tankki95 = Integer.parseInt(kasitteleRivi(br.readLine()));
			tankki98 = Integer.parseInt(kasitteleRivi(br.readLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void paivitaTankit(String txtTankit) {
		try {					
			FileWriter fwriter = new FileWriter(filenameTankit);
			fwriter.write(txtTankit);
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String kasitteleRivi(String txt) {
		txt = txt.replace(" ", "");
		String[] temp = txt.split("=");
		return temp[1];
	}
	
	public void tallennaOstokset(String txtOstokset) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filenameOstokset, true);
			fwriter.write(date.toString() + " : ");
			fwriter.write(txtOstokset + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String crypt(String str) {
	    if (str == null || str.length() == 0) {
	        throw new IllegalArgumentException("String to encript cannot be null or zero length");
	    }
	
	    MessageDigest digester;
	    try {
	        digester = MessageDigest.getInstance("MD5");
	
	        digester.update(str.getBytes());
	        byte[] hash = digester.digest();
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10) {
	                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	            } else {
	                hexString.append(Integer.toHexString(0xFF & hash[i]));
	            }
	        }
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}


}
