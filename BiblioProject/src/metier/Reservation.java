package metier;

import java.sql.Date;


public class Reservation {
	
	private int idReservation ;
	private String dateReservation;
	private Date dateAnnulation;
	private int OeuvreID;
	private int UsagerID;
	
	
	public Reservation(String dateReservation, int OeuvreID, int UsagerID) {
		super();
		
		this.dateReservation = dateReservation;
		this.OeuvreID = OeuvreID;
		this.UsagerID = UsagerID;
	}


	public int getidReservation() {
		return idReservation;
	}


	public void setidReservation(int idReservation) {
		this.idReservation = idReservation;
	}


	public String getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}


	public Date getDateAnnulation() {
		return dateAnnulation;
	}


	public void setDateAnnulation(Date dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}

	public int getOeuvreID() {
		return OeuvreID;
	}


	public void setOeuvreID(int oeuvreID) {
		OeuvreID = oeuvreID;
	}


	public int getUsagerID() {
		return UsagerID;
	}


	public void setUsagerID(int usagerID) {
		UsagerID = usagerID;
	}
	
	

}
