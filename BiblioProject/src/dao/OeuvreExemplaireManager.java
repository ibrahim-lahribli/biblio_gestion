package dao;

import metier.Exemplaire;
import metier.Oeuvre;

public class OeuvreExemplaireManager implements IOeuvreExemplaireManager {
	
	
      public boolean ajouter(Oeuvre o) {
		
		
		DBinteraction.connect();
		String sql= "insert into oeuvre (Titre,Auteur,Type,landing) values ('"+o.getTitre()+"','"+o.getAuteur()+"','"+o.getType()+"',"+o.getLanding()+")";
		DBinteraction.update(sql);
		DBinteraction.disconnect();
		return true;		
	}

     public void lister(){
	
	
	   DBinteraction.connect();
	   String sql = "select * from oeuvre";
	   DBinteraction.select(sql);	
    }

     public void Rechercher(String titre){
	
	
   	  DBinteraction.connect();
	  String sql = "select * from oeuvre where Titre = '"+titre+"'";
	  DBinteraction.select(sql);

    }

     public void Supprimer(int id){
    	 
	  DBinteraction.connect();
	  String sql = "delete from oeuvre where ID='"+id+"'";
	  DBinteraction.update(sql);
    }

    public void AjouterExemplaire(Exemplaire e){
	
	  DBinteraction.connect();
	  String sql= "insert into exemplaire (OeuvreID,Etat) values ("+e.getIdOeuvre()+",'"+e.getEtat()+"')";
	  DBinteraction.update(sql);
	  DBinteraction.disconnect();	
    }
    public void listerExemplaire(){
    	
    	
 	   DBinteraction.connect();
 	   String sql = "select * from exemplaire";
 	   DBinteraction.select(sql);	
     }
    
    
    public void SupprimerExemplaire(int id){
   	 
  	  DBinteraction.connect();
  	  String sql = "delete from exemplaire where ID='"+id+"'";
  	  DBinteraction.update(sql);
      }
    
public void ModifierExemplaire(Exemplaire e,int idr){
		
		DBinteraction.connect();
		String sql = "update exemplaire set OeuvreID ='"+e.getIdOeuvre()+"',Etat='"+e.getEtat()+"' where ID='"+idr+"'";
		DBinteraction.update(sql);
	}
public void RechercherExemplaire(int idr){
	
	
 	  DBinteraction.connect();
	  String sql = "select * from exemplaire where ID = '"+idr+"'";
	  DBinteraction.select(sql);

  }


}
