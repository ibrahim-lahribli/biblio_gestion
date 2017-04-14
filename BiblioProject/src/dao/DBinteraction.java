package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBinteraction {
	
	public static Connection con;     				
	public static ResultSet rs = null;							
	public static PreparedStatement pst;				
	public static java.sql.Statement st;
		
		
		public static Connection connect (){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url ="jdbc:mysql://localhost/testbibal";
				
				try {
					con = DriverManager.getConnection(url,"root","");
					st=con.createStatement();
					System.out.println("connexion ruessie");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		
		
		public static void disconnect (){
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public static ResultSet select(String sql){
			
			try {
				rs=st.executeQuery(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
			
			
		}
		
		public static int update(String sql){
	    	int nb=0;
	    	try {       		
				nb = st.executeUpdate(sql);
			} catch (SQLException e) {			
				e.printStackTrace();
			}
	    	return nb;
	    }

}
