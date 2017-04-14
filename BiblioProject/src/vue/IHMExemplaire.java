package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.OeuvreExemplaireController;
import net.proteanit.sql.DbUtils;
import dao.DBinteraction;

public class IHMExemplaire extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OeuvreExemplaireController control = new OeuvreExemplaireController();
	private JPanel contentPane;
	private JTextField IdOeuvretextField;
	private JTable ExemplaireTable;
	JComboBox ExecomboBox = new JComboBox();
	private JTextField IDRechtextField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMExemplaire frame = new IHMExemplaire();
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
	public IHMExemplaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		combobox();	

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(604, 11, 577, 545);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblExemplaire = new JLabel("Exemplaire");
		lblExemplaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExemplaire.setBounds(141, 11, 126, 25);
		panel_1.add(lblExemplaire);
		
		JLabel lblAjouterExemplaire = new JLabel("Ajouter Exemplaire :");
		lblAjouterExemplaire.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjouterExemplaire.setBounds(10, 58, 169, 25);
		panel_1.add(lblAjouterExemplaire);
		
		JLabel lblEtat = new JLabel("Etat :");
		lblEtat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEtat.setBounds(10, 198, 59, 19);
		panel_1.add(lblEtat);
		
		JComboBox EtatcomboBox = new JComboBox();
		EtatcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Neuf", "Bon", "Vieux"}));
		EtatcomboBox.setBounds(102, 199, 86, 20);
		panel_1.add(EtatcomboBox);
		
		JLabel lblIdOeuvre = new JLabel("Id Oeuvre :");
		lblIdOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdOeuvre.setBounds(10, 160, 82, 14);
		panel_1.add(lblIdOeuvre);
		
		IdOeuvretextField = new JTextField();
		IdOeuvretextField.setBounds(102, 159, 86, 20);
		panel_1.add(IdOeuvretextField);
		IdOeuvretextField.setColumns(10);
		
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.AddExemlpaire(Integer.parseInt(IdOeuvretextField.getText()),EtatcomboBox.getSelectedItem().toString());
				refreshTable();
				vider();
			}
		});
		btnAjouter_1.setBounds(43, 238, 94, 25);
		panel_1.add(btnAjouter_1);
		
		JLabel lblOeuvre_1 = new JLabel("Oeuvre :");
		lblOeuvre_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOeuvre_1.setBounds(10, 122, 71, 14);
		panel_1.add(lblOeuvre_1);
		ExecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TakeFromCombo();	
			}
		});
		
			
		ExecomboBox.setBounds(102, 121, 86, 20);
		panel_1.add(ExecomboBox);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(233, 47, 313, 482);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lister Exemplaire :");
		lblNewLabel_1.setBounds(88, 11, 152, 19);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 57, 293, 303);
		panel_3.add(scrollPane_1);
		
		ExemplaireTable = new JTable();
		scrollPane_1.setViewportView(ExemplaireTable);
		
		JButton btnNewButton_1 = new JButton("Lister ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.listerExemplaire();
				ExemplaireTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(20, 369, 89, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = ExemplaireTable.getSelectedRow();
				String idr=(ExemplaireTable.getModel().getValueAt(row, 0)).toString();
				control.DeleteExemplaire(Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		btnNewButton_2.setBounds(20, 448, 89, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = ExemplaireTable.getSelectedRow();
				String idr=(ExemplaireTable.getModel().getValueAt(row, 0)).toString();
				control.UpdateExemplaire(Integer.parseInt(IdOeuvretextField.getText()),EtatcomboBox.getSelectedItem().toString(), Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		btnNewButton_3.setBounds(171, 448, 89, 23);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.RechercherExemplaire(Integer.parseInt(IDRechtextField.getText()));
				ExemplaireTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));

			}
		});
		btnNewButton.setBounds(20, 414, 89, 23);
		panel_3.add(btnNewButton);
		
		IDRechtextField = new JTextField();
		IDRechtextField.setBounds(129, 413, 105, 24);
		panel_3.add(IDRechtextField);
		IDRechtextField.setColumns(10);
		
		
		ExemplaireTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try {
						int row = ExemplaireTable.getSelectedRow();
						String ID_=(ExemplaireTable.getModel().getValueAt(row, 1)).toString();
						String query="select Titre ,OeuvreID , Etat from oeuvre,exemplaire where oeuvre.ID=exemplaire.OeuvreID and OeuvreID='"+Integer.parseInt(ID_)+"'";
						PreparedStatement pst=DBinteraction.con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						
						while(rs.next())
						{
							ExecomboBox.setSelectedItem(rs.getString("Titre"));
							IdOeuvretextField.setText(rs.getString("OeuvreID"));
							EtatcomboBox.setSelectedItem(rs.getString("Etat"));	
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
		       }
			  );
	 
		
		
		
	
	}
	public void refreshTable(){
		
	    control.listerExemplaire();
		ExemplaireTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
   }

  public void vider(){
	  
	IdOeuvretextField.setText("");
	}
	
	
	public void combobox(){
		  
		  
		  try {
			String sql = "select * from oeuvre";  
			PreparedStatement pst = DBinteraction.connect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ExecomboBox.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }  
		public void TakeFromCombo(){
		
				try {
					String sql = "select * from oeuvre where Titre=?";
					PreparedStatement pst=DBinteraction.connect().prepareStatement(sql);
					pst.setString(1,(String) ExecomboBox.getSelectedItem());			
					ResultSet rs=pst.executeQuery();			
					while(rs.next()){
						IdOeuvretextField.setText(rs.getString(1));
						IdOeuvretextField.setEditable(false);}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								 
		}
	}
