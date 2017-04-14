package dao;

import metier.Exemplaire;
import metier.Oeuvre;

public interface IOeuvreExemplaireManager {
	
	public boolean ajouter(Oeuvre o);
	public void lister();
	public void Rechercher(String titre);
	public void Supprimer(int id);
	public void AjouterExemplaire(Exemplaire e);
	public void SupprimerExemplaire(int id);
	public void ModifierExemplaire(Exemplaire e,int idr);
	public void RechercherExemplaire(int idr);

}
