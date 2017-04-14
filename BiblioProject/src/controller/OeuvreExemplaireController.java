package controller;

import metier.Exemplaire;
import metier.Oeuvre;
import  dao.OeuvreExemplaireManager;;


public class OeuvreExemplaireController {
	
    static OeuvreExemplaireManager OeuvreExemplaireManager;
	
	public OeuvreExemplaireController(){
		
		OeuvreExemplaireManager = new OeuvreExemplaireManager();	
	}
	
	public void AddOeuvre(String titre,String auteur,String type,int landing){
		 Oeuvre o = new Oeuvre(titre, auteur, type, landing);
		 OeuvreExemplaireManager.ajouter(o);	
	}
	public void lister(){
		
		OeuvreExemplaireManager.lister();
	}
	
	public void search(String titre){
		OeuvreExemplaireManager.Rechercher(titre);
	}
	
	public void Delete(int id){
		OeuvreExemplaireManager.Supprimer(id);
	}
	
	public void AddExemlpaire(int idOeuvre,String etat){
		
		Exemplaire e = new Exemplaire(idOeuvre, etat);
		OeuvreExemplaireManager.AjouterExemplaire(e);
	}
	
	public void listerExemplaire(){
		
		OeuvreExemplaireManager.listerExemplaire();
	}
	
	public void DeleteExemplaire(int id){
		OeuvreExemplaireManager.SupprimerExemplaire(id);
	}
	
	public void UpdateExemplaire(int idOeuvre,String etat,int idr){
		
		Exemplaire e = new Exemplaire(idOeuvre, etat);
		OeuvreExemplaireManager.ModifierExemplaire(e,idr);
	}
	public void RechercherExemplaire(int idr){
		
		OeuvreExemplaireManager.RechercherExemplaire(idr);
	}
}
