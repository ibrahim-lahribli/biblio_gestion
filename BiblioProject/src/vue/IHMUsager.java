package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;
import controller.Usagercontroller;
import dao.DBinteraction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IHMUsager {

	private JFrame frame;
	private JTextField IdField;
	private JTextField NomField;
	private JTextField PrenomField;
	Usagercontroller control = new Usagercontroller();
	
	
	private JTable UsagerTable;
	private JTextField RechercheField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMUsager window = new IHMUsager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refreshTable(){
		
		    control.lister();
			UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
	}
	
	public void vider(){
		IdField.setText("");
		NomField.setText("");
		PrenomField.setText("");
		}


	/**
	 * Create the application.
	 */
	public IHMUsager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel AjouterPanel = new JPanel();
		AjouterPanel.setBounds(10, 11, 304, 447);
		frame.getContentPane().add(AjouterPanel);
		AjouterPanel.setLayout(null);
		
		JLabel lblAjouterUsager = new JLabel("AJOUTER USAGER");
		lblAjouterUsager.setBounds(93, 21, 136, 19);
		AjouterPanel.add(lblAjouterUsager);
		lblAjouterUsager.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 96, 34, 25);
		AjouterPanel.add(lblId);
		
		IdField = new JTextField();
		IdField.setBounds(90, 96, 120, 25);
		AjouterPanel.add(IdField);
		IdField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(10, 175, 48, 25);
		AjouterPanel.add(lblNom);
		
		NomField = new JTextField();
		NomField.setBounds(90, 175, 120, 25);
		AjouterPanel.add(NomField);
		NomField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(10, 242, 78, 31);
		AjouterPanel.add(lblPrenom);
		
		PrenomField = new JTextField();
		PrenomField.setBounds(93, 248, 117, 25);
		AjouterPanel.add(PrenomField);
		PrenomField.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control.addUsager(Integer.parseInt(IdField.getText()), NomField.getText(), PrenomField.getText());		
			}
			
		});
		btnAjouter.setBounds(29, 335, 89, 23);
		AjouterPanel.add(btnAjouter);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setBounds(177, 335, 89, 23);
		AjouterPanel.add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int row = UsagerTable.getSelectedRow();
				String idr=(UsagerTable.getModel().getValueAt(row, 0)).toString();
				control.UpdateUsager(Integer.parseInt(IdField.getText()), NomField.getText(),PrenomField.getText(), Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(379, 11, 313, 447);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblListerUsagers = new JLabel("LISTER USAGERS");
		lblListerUsagers.setBounds(83, 11, 152, 27);
		lblListerUsagers.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblListerUsagers);
		
		
		
		JButton btnLister = new JButton("LISTER");
		btnLister.setBounds(10, 366, 115, 23);
		
		btnLister.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent e) {
				
			    control.lister();
				UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				
			}
		});
		panel.add(btnLister);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 52, 200, 295);
		panel.add(scrollPane);
		
		UsagerTable = new JTable();
		scrollPane.setViewportView(UsagerTable);
		
		RechercheField = new JTextField();
		RechercheField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				control.searchUsager(RechercheField.getText());
				UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				
			}
		});
		RechercheField.setBounds(126, 403, 105, 20);
		panel.add(RechercheField);
		RechercheField.setColumns(10);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setBounds(140, 366, 115, 23);
		panel.add(btnSupprimer);
		
		JLabel lblRechercher = new JLabel("Rechercher :");
		lblRechercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRechercher.setBounds(20, 404, 83, 14);
		panel.add(lblRechercher);
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = UsagerTable.getSelectedRow();
				String idr=(UsagerTable.getModel().getValueAt(row, 0)).toString();
				control.deleteUsager(Integer.parseInt(idr));
				refreshTable();
				vider();
				
			}
		});
		
		UsagerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try {
						int row = UsagerTable.getSelectedRow();
						String ID_=(UsagerTable.getModel().getValueAt(row, 0)).toString();
						String query="select * from usager where ID='"+Integer.parseInt(ID_)+"'";
						PreparedStatement pst=DBinteraction.con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						while(rs.next())
						{
							IdField.setText(rs.getString("ID"));
							NomField.setText(rs.getString("Nom"));
							PrenomField.setText(rs.getString("Prenom"));
							
							
						}
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		);
		
		
	}
}
