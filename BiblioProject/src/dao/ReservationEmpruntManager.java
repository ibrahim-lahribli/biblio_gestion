package dao;

import metier.Emprunt;
import metier.Reservation;

public class ReservationEmpruntManager implements IReservationEmpruntManager{

	@Override
	public void Reserver(Reservation r) {
		
		DBinteraction.connect();
		String sql= "insert into reservation (OeuvreID,UsagerID,DateReservation) values ("+r.getOeuvreID()+","+r.getUsagerID()+",'"+r.getDateReservation()+"')";
		DBinteraction.update(sql);
		DBinteraction.disconnect();
	}

	@Override
	public void Identifier(int IdOeuvre, int IdUsager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Annuler(String DateAnnulation,int idr) {
		
		DBinteraction.connect();
		String sql = "update reservation set DateAnnulation ='"+DateAnnulation+"'where ID='"+idr+"'";
		DBinteraction.update(sql);
		
	}

	@Override
	public void lister() {
		
		DBinteraction.connect();
		   String sql = "select * from reservation";
		   DBinteraction.select(sql);	
		
	}

	@Override
	public void Emprunter(Emprunt e) {
		
		DBinteraction.connect();
		String sql= "insert into emprunt (ExemplaireID,UsagerID,DateEmprunt,DateRetourAnnonce) values ("+e.getExemplaireID()+","+e.getUsagerID()+",'"+e.getDateEmprunt()+"','"+e.getDateRetourAnnonce()+"')";
		DBinteraction.update(sql);
		DBinteraction.disconnect();

		
	}

	@Override
	public void IdentifierEmprunt(int UsagerID, int ExemplaireID) {
		
		
	}
}
