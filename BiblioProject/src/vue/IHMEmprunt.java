package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import controller.Usagercontroller;

public class IHMEmprunt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField IdUsagerField;
	static JTextField NomUsagerField;
	Usagercontroller controlUsager = new Usagercontroller();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMEmprunt frame = new IHMEmprunt();
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
	public IHMEmprunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmprunterExemplaire = new JLabel("Emprunter Exemplaire");
		lblEmprunterExemplaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmprunterExemplaire.setBounds(10, 11, 234, 25);
		contentPane.add(lblEmprunterExemplaire);
		
		JButton btnIdetifierUsager = new JButton("Idetifier Usager");
		btnIdetifierUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Identifier_Usager_Emprunt ihm = new Identifier_Usager_Emprunt();
				ihm.setVisible(true);
			}
		});
		btnIdetifierUsager.setBounds(52, 70, 134, 23);
		contentPane.add(btnIdetifierUsager);
		
		JLabel lblIdentifierUsager = new JLabel("Identifiant Usager :");
		lblIdentifierUsager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdentifierUsager.setBounds(10, 117, 134, 23);
		contentPane.add(lblIdentifierUsager);
		
		IdUsagerField = new JTextField();
		IdUsagerField.setEditable(false);
		IdUsagerField.setBounds(172, 120, 120, 20);
		contentPane.add(IdUsagerField);
		IdUsagerField.setColumns(10);
		
		JLabel lblNomUsager = new JLabel("Nom Usager :");
		lblNomUsager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomUsager.setBounds(46, 151, 98, 19);
		contentPane.add(lblNomUsager);
		
		NomUsagerField = new JTextField();
		NomUsagerField.setEditable(false);
		NomUsagerField.setBounds(172, 152, 120, 20);
		contentPane.add(NomUsagerField);
		NomUsagerField.setColumns(10);
		
		JButton btnSelectionnerExemplaire = new JButton("Selectionner Exemplaire :");
		btnSelectionnerExemplaire.setBounds(36, 216, 160, 23);
		contentPane.add(btnSelectionnerExemplaire);
	}
}
