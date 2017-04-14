package dao;

import metier.Usager;

public interface IusagerManager {
	
	public boolean ajouter(Usager u);
	public Boolean lister();
	public void Modifier(Usager u,int idr);
	public void supprimer(int id);
	public boolean Rechercher(String nom);

}
