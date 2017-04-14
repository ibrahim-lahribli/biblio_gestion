package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JButton;

import dao.DBinteraction;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Selectionner_emprunt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox OeuvrecomboBox = new JComboBox();
	private JComboBox ExempalireComboBox = new JComboBox();
	
	private JTextField TitreTextField;
	private JTextField IDtextField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selectionner_emprunt frame = new Selectionner_emprunt();
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
	public Selectionner_emprunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		combobox();
		combobox_1();
		
		JLabel lblSelectionnerExemplaire = new JLabel("Selectionner Exemplaire");
		lblSelectionnerExemplaire.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectionnerExemplaire.setBounds(111, 11, 191, 19);
		contentPane.add(lblSelectionnerExemplaire);
		
		JLabel lblTitreOeuvre = new JLabel("Titre Oeuvre :");
		lblTitreOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitreOeuvre.setBounds(10, 51, 98, 19);
		contentPane.add(lblTitreOeuvre);
		OeuvrecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TakeFromCombo();
			}
		});
		
		OeuvrecomboBox.setBounds(135, 52, 128, 20);
		contentPane.add(OeuvrecomboBox);
		
		JLabel lblIdExemplaire = new JLabel("Id Exemplaire :");
		lblIdExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdExemplaire.setBounds(10, 88, 104, 19);
		contentPane.add(lblIdExemplaire);
		ExempalireComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TakeFromCombo_1();
			}
		});
		
		
		ExempalireComboBox.setBounds(135, 89, 128, 20);
		contentPane.add(ExempalireComboBox);
		
		JButton btnNewButton = new JButton("Selectionner");
		btnNewButton.setBounds(79, 145, 98, 23);
		contentPane.add(btnNewButton);
		
		TitreTextField = new JTextField();
		TitreTextField.setBounds(22, 203, 86, 23);
		contentPane.add(TitreTextField);
		TitreTextField.setColumns(10);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(135, 204, 86, 21);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
	}
     public void TakeFromCombo(){
		
		try {
			String sql = "select * from oeuvre where Titre=?";
			PreparedStatement pst=DBinteraction.connect().prepareStatement(sql);
			pst.setString(1,(String) OeuvrecomboBox.getSelectedItem());			
			ResultSet rs=pst.executeQuery();			
			while(rs.next()){
				TitreTextField.setText(rs.getString(1));
				;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						 
     }
     public void combobox(){
		  
		  
		  try {
			String sql = "select * from oeuvre";  
			PreparedStatement pst = DBinteraction.connect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				OeuvrecomboBox.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  } 
     public void TakeFromCombo_1(){
 		
		try {
			String sql = "select * from exemplaire where ID=?";
			PreparedStatement pst=DBinteraction.connect().prepareStatement(sql);
			pst.setString(1,(String) ExempalireComboBox.getSelectedItem());			
			ResultSet rs=pst.executeQuery();			
			while(rs.next()){
				IDtextField.setText(rs.getString(1));
				;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						 
     }
     public void combobox_1(){
		  
		  
		  try {
			String sql = "select * from exemplaire";  
			PreparedStatement pst = DBinteraction.connect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ExempalireComboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  } 
     

}
