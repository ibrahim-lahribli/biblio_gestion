package dao;

import metier.Emprunt;
import metier.Reservation;

public interface IReservationEmpruntManager {
	
	public void Reserver(Reservation r);
	public void Identifier(int IdOeuvre, int IdUsager);
	public void Annuler(String DateAnnulation,int idr);
	public void lister();
	public void Emprunter(Emprunt e);
	public void IdentifierEmprunt(int UsagerID, int ExemplaireID);
	
}