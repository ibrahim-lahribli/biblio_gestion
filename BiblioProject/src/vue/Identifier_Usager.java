package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Usagercontroller;
import net.proteanit.sql.DbUtils;
import dao.DBinteraction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Identifier_Usager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable Usagertable;
	Usagercontroller control = new Usagercontroller();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identifier_Usager frame = new Identifier_Usager();
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
	
	public Identifier_Usager() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblIdentifierUsager = new JLabel("Identifier Usager");
		lblIdentifierUsager.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdentifierUsager.setBounds(111, 11, 134, 25);
		contentPane.add(lblIdentifierUsager);
		
		JLabel lblNomUsager = new JLabel("Nom Usager :");
		lblNomUsager.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomUsager.setBounds(10, 56, 91, 19);
		contentPane.add(lblNomUsager);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
		
				control.searchUsager(textField.getText());
				Usagertable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
			}
		});
		textField.setBounds(111, 57, 134, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 144, 335, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 269, 166);
		panel.add(scrollPane);
		Usagertable = new JTable();
		Usagertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		scrollPane.setViewportView(Usagertable);
		
		control.lister();
		Usagertable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
		
		JButton btnSelectionner = new JButton("Selectionner");
		btnSelectionner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int row = Usagertable.getSelectedRow();
					String ID_=(Usagertable.getModel().getValueAt(row, 0)).toString();
					String query="select * from usager where ID='"+Integer.parseInt(ID_)+"'";
					PreparedStatement pst=DBinteraction.con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						IHMReservation.IDusagerTextField.setText(rs.getString("ID"));
						IHMReservation.NomtextField.setText(rs.getString("Nom"));
						
						
					}
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}dispose();
			}
			
		});
		btnSelectionner.setBounds(141, 89, 126, 25);
		contentPane.add(btnSelectionner);
		
		JLabel lblNewLabel = new JLabel("Selectionner un usager de la table");
		lblNewLabel.setBounds(10, 125, 235, 14);
		contentPane.add(lblNewLabel);
		
	}
	
}
