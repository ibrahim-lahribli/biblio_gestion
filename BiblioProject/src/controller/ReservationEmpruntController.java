package controller;

import metier.Reservation;
import dao.ReservationEmpruntManager;
import dao.UsagerManager;

public class ReservationEmpruntController {
	
	static ReservationEmpruntManager ReservationEmpruntManager;
	static UsagerManager usagerManager;
	
	public ReservationEmpruntController(){
		
		ReservationEmpruntManager = new ReservationEmpruntManager();
		usagerManager = new UsagerManager();
	}
	
	public void Reserver(int OeuvreID,int UsagerID,String dateReservation){

		
		Reservation r = new Reservation(dateReservation, OeuvreID, UsagerID);
		ReservationEmpruntManager.Reserver(r);
	}
	
	public void lister(){
		
		ReservationEmpruntManager.lister();
	}
	
	public void Annuler(String DateAnnulation,int idr){
		
		ReservationEmpruntManager.Annuler(DateAnnulation, idr);
	}
	

}
