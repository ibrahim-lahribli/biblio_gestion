package dao;

import metier.Usager;


public class UsagerManager implements IusagerManager{
	
	
	public boolean ajouter(Usager u) {
		
		DBinteraction.connect();
		String sql= "insert into usager (nom,prenom) values ('"+u.getNom()+"','"+u.getPrenom()+"')";
		DBinteraction.update(sql);
		DBinteraction.disconnect();
		return true;		
	}
	
	public Boolean lister(){
		
		DBinteraction.connect();
		String sql = "select * from usager";
		DBinteraction.select(sql);
		
		return true;
		
	}	
	
	public void Modifier(Usager u,int idr){
		
		DBinteraction.connect();
		String sql = "update usager set nom ='"+u.getNom()+"',prenom='"+u.getPrenom()+"' where ID='"+idr+"'";
		DBinteraction.update(sql);
	}
	public void supprimer(int id){
		
		DBinteraction.connect();
		String sql = "delete from usager where ID='"+id+"'";
		DBinteraction.update(sql);
	}
    public boolean Rechercher(String nom){
		
		
		DBinteraction.connect();
		String sql = "select * from usager where nom = '"+nom+"'";
		DBinteraction.select(sql);
		return true;
		
	}
    
}