package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controller.ReservationEmpruntController;
import controller.Usagercontroller;
import dao.DBinteraction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class IHMReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox OeuvrecomboBox = new JComboBox();
	
	ReservationEmpruntController control = new ReservationEmpruntController();
	Usagercontroller controlUsager = new Usagercontroller();
	static JTextField NomtextField;
	static JTextField DateRestextField;
	static JTextField IDusagerTextField;
	private JTextField IDtextField;
	private JTable ResaTable;
	private JTextField textField_1;
	private JTextField DateAnntextField;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMReservation frame = new IHMReservation();
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
	
	public IHMReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		combobox();
		
		JLabel lblCreerUneReservaion = new JLabel("Creer Une Reservation");
		lblCreerUneReservaion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreerUneReservaion.setBounds(10, 11, 235, 38);
		contentPane.add(lblCreerUneReservaion);
		
		JLabel lblOeuvre = new JLabel("Selectioner Oeuvre :");
		lblOeuvre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOeuvre.setBounds(10, 193, 139, 24);
		contentPane.add(lblOeuvre);
		OeuvrecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TakeFromCombo();
			}
		});
		
		OeuvrecomboBox.setBounds(170, 197, 114, 20);
		contentPane.add(OeuvrecomboBox);
		
		JLabel lblDateDeReservation = new JLabel("Date Reservation :");
		lblDateDeReservation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDeReservation.setBounds(10, 242, 123, 24);
		contentPane.add(lblDateDeReservation);
		
		JButton btnReserver = new JButton("Reserver");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.Reserver(Integer.parseInt(IDtextField.getText()),Integer.parseInt(IDusagerTextField.getText()),DateRestextField.getText());
				vider();
				
			}
		});
		btnReserver.setBounds(93, 277, 89, 30);
		contentPane.add(btnReserver);
		
		JLabel lblIdentifier = new JLabel("Identifiant Usager :");
		lblIdentifier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdentifier.setBounds(10, 115, 139, 20);
		contentPane.add(lblIdentifier);
		
		JButton btnNewButton = new JButton("Identifier Usager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Identifier_Usager ihm = new Identifier_Usager();
				ihm.setVisible(true);
			}
		});
		btnNewButton.setBounds(79, 71, 139, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNomUsager = new JLabel("Nom Usager :");
		lblNomUsager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomUsager.setBounds(41, 148, 123, 20);
		contentPane.add(lblNomUsager);
		
		NomtextField = new JTextField();
		NomtextField.setColumns(10);
		NomtextField.setBounds(170, 150, 114, 20);
		contentPane.add(NomtextField);
		NomtextField.setEditable(false);
		
		DateRestextField = new JTextField();
		DateRestextField.setBounds(170, 246, 114, 20);
		contentPane.add(DateRestextField);
		DateRestextField.setColumns(10);
		
		
		IDusagerTextField = new JTextField();
		IDusagerTextField.setColumns(10);
		IDusagerTextField.setBounds(170, 117, 114, 20);
		contentPane.add(IDusagerTextField);
		IDusagerTextField.setEditable(false);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(10, 228, 114, 3);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(312, 11, 331, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 321, 266);
		panel.add(scrollPane);
		
		ResaTable = new JTable();
		scrollPane.setViewportView(ResaTable);
		
		JButton btnLister = new JButton("Lister");
		btnLister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.lister();
				ResaTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));

			}
		});
		btnLister.setBounds(10, 364, 89, 23);
		panel.add(btnLister);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 399, 101, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblListerReservations = new JLabel("Lister Reservations");
		lblListerReservations.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListerReservations.setBounds(56, 0, 200, 50);
		panel.add(lblListerReservations);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRechercher.setBounds(10, 398, 89, 23);
		panel.add(btnRechercher);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = ResaTable.getSelectedRow();
				String idr=(ResaTable.getModel().getValueAt(row, 0)).toString();
				control.Annuler(DateAnntextField.getText(),Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		btnAnnuler.setBounds(79, 440, 89, 23);
		contentPane.add(btnAnnuler);
		
		DateAnntextField = new JTextField();
		DateAnntextField.setBounds(147, 394, 111, 20);
		contentPane.add(DateAnntextField);
		DateAnntextField.setColumns(10);
		
		JLabel lblDateDannulation = new JLabel("Date D'annulation");
		lblDateDannulation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDannulation.setBounds(10, 390, 123, 24);
		contentPane.add(lblDateDannulation);
		
		JLabel lblAnnulerReservation = new JLabel("Annuler Reservation");
		lblAnnulerReservation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnnulerReservation.setBounds(18, 357, 200, 24);
		contentPane.add(lblAnnulerReservation);
		IDtextField.setVisible(false);
		
		ResaTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try {
						int row = ResaTable.getSelectedRow();
						String ID_=(ResaTable.getModel().getValueAt(row, 0)).toString();
						String query="select UsagerID,Nom,Titre,DateReservation from usager,oeuvre,reservation where reservation.OeuvreID=oeuvre.ID and reservation.UsagerID=usager.ID and reservation.ID ='"+ID_+"'";

						PreparedStatement pst=DBinteraction.con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						while(rs.next())
						{
							IDusagerTextField.setText(rs.getString("UsagerID"));
							NomtextField.setText(rs.getString("Nom"));
							OeuvrecomboBox.setSelectedItem(rs.getString("Titre"));
							DateRestextField.setText(rs.getString("DateReservation"));	
						}
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
		       }
			  );
	}
	
   public void refreshTable(){
		
	    control.lister();;
		ResaTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
   }

  public void vider(){
	  
	IDusagerTextField.setText("");
	NomtextField.setText("");
	DateRestextField.setText("");
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
	
	public void TakeFromCombo(){
		
		try {
			String sql = "select * from oeuvre where Titre=?";
			PreparedStatement pst=DBinteraction.connect().prepareStatement(sql);
			pst.setString(1,(String) OeuvrecomboBox.getSelectedItem());			
			ResultSet rs=pst.executeQuery();			
			while(rs.next()){
				IDtextField.setText(rs.getString(1));
				;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						 
     }
}
