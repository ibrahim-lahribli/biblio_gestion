package controller;

import metier.Usager;
import dao.UsagerManager;

public class Usagercontroller {
	
	static UsagerManager UsagerManager;
	
	public Usagercontroller(){
		UsagerManager = new UsagerManager();	
	}
	
	public boolean addUsager(int id, String nom,String prenom){
		
		Usager u = new Usager(id, nom, prenom);
		UsagerManager.ajouter(u);
		
		return false;
		
	}
	public void lister(){
		
		UsagerManager.lister();
	}
	public void UpdateUsager(int id,String nom, String prenom,int idr){
		
		Usager u = new Usager(id,nom,prenom);
		UsagerManager.Modifier(u, idr);
		}
	public void deleteUsager(int id){
		UsagerManager.supprimer(id);
	}
	public void searchUsager(String nom){
		UsagerManager.Rechercher(nom);
	}
}
	