package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import controller.OeuvreExemplaireController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import dao.DBinteraction;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IHMOeurvre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TitreField;
	private JTextField AuteurField;
	
	OeuvreExemplaireController control = new OeuvreExemplaireController();
	private JTable OeuvreTable;
	private JTextField RechercherField;
	private JComboBox TypecomboBox;

	

	/**
	 * Launch the application.
	 */
	

  
  public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMOeurvre frame = new IHMOeurvre();
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
	@SuppressWarnings("unchecked")
	public IHMOeurvre() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 584, 552);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOeuvre = new JLabel("Oeuvre");
		lblOeuvre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOeuvre.setBounds(221, 11, 97, 25);
		panel.add(lblOeuvre);
		
		JLabel lblAjouterOeuvre = new JLabel("Ajouter Oeuvre : ");
		lblAjouterOeuvre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjouterOeuvre.setBounds(32, 70, 133, 14);
		panel.add(lblAjouterOeuvre);
		
		JLabel lblNewLabel = new JLabel("Titre : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 118, 60, 14);
		panel.add(lblNewLabel);
		
		TitreField = new JTextField();
		TitreField.setBounds(117, 117, 86, 20);
		panel.add(TitreField);
		TitreField.setColumns(10);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuteur.setBounds(32, 173, 60, 14);
		panel.add(lblAuteur);
		
		AuteurField = new JTextField();
		AuteurField.setBounds(117, 172, 86, 20);
		panel.add(AuteurField);
		AuteurField.setColumns(10);
		
		JLabel lblType = new JLabel("Type : ");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(32, 222, 60, 19);
		panel.add(lblType);
		
		TypecomboBox = new JComboBox();
		TypecomboBox.setModel(new DefaultComboBoxModel(new String[] {"magazine ", "livre"}));
		TypecomboBox.setBounds(117, 221, 86, 20);
		panel.add(TypecomboBox);
		
		JLabel lblLanding = new JLabel("Landing :");
		lblLanding.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLanding.setBounds(32, 271, 68, 19);
		panel.add(lblLanding);
		
		JComboBox LandingcomboBox = new JComboBox();
		LandingcomboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "30"}));
		LandingcomboBox.setBounds(117, 270, 86, 20);
		panel.add(LandingcomboBox);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.AddOeuvre(TitreField.getText(), AuteurField.getText(),TypecomboBox.getSelectedItem().toString(),Integer.parseInt(LandingcomboBox.getSelectedItem().toString()));
				
				
			}
		});
		btnAjouter.setBounds(76, 318, 89, 23);
		panel.add(btnAjouter);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(282, 48, 292, 464);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Lister Oeuvre : ");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(97, 11, 116, 19);
		panel_2.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 272, 306);
		panel_2.add(scrollPane);
		
		OeuvreTable = new JTable();
		scrollPane.setViewportView(OeuvreTable);
		
		JButton btnLister = new JButton("Lister");
		btnLister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.lister();
				OeuvreTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));

				
			}
		});
		btnLister.setBounds(20, 383, 89, 23);
		panel_2.add(btnLister);
		
		JButton Rechercherbutton = new JButton("Rechercher");
		Rechercherbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.search(RechercherField.getText());
				OeuvreTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				TypecomboBox.setSelectedItem(arg0);
			}
		});
		Rechercherbutton.setBounds(20, 417, 89, 23);
		panel_2.add(Rechercherbutton);
		
		RechercherField = new JTextField();
		RechercherField.setBounds(139, 418, 86, 20);
		panel_2.add(RechercherField);
		RechercherField.setColumns(10);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int row = OeuvreTable.getSelectedRow();
				String idr=(OeuvreTable.getModel().getValueAt(row, 0)).toString();
				control.Delete(Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		btnSupprimer.setBounds(131, 383, 94, 23);
		panel_2.add(btnSupprimer);
		
		JButton btnNewButton = new JButton("Exemplaire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				IHMExemplaire ihm = new IHMExemplaire();
				ihm.setVisible(true);
			}
		});
		btnNewButton.setBounds(32, 392, 108, 32);
		panel.add(btnNewButton);
		
		
		OeuvreTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try {
						int row = OeuvreTable.getSelectedRow();
						String ID_=(OeuvreTable.getModel().getValueAt(row, 0)).toString();
						String query="select * from oeuvre where ID='"+Integer.parseInt(ID_)+"'";
						PreparedStatement pst=DBinteraction.con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						while(rs.next())
						{
							
							
							TitreField.setText(rs.getString("Titre"));
							AuteurField.setText(rs.getString("Auteur"));
							TypecomboBox.setSelectedItem(rs.getString("Type"));
							
						}
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
		       }
			  );
		
	}
	public void refreshTable(){
		
	    control.lister();
		OeuvreTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
}

  public void vider(){
	TitreField.setText("");
	AuteurField.setText("");	
	}
}

