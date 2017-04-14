package metier;

import java.util.ArrayList;

public class Oeuvre {
	

		private int idOeuvre;
		private String titre;
		private String auteur;
		private String type;
		private int nbReservation;
		private int landing ;
		private ArrayList<Exemplaire>exemplairelist;
		private ArrayList<Reservation>reservationlist;
		
		public Oeuvre(String titre, String auteur, String type,int landing) {
			super();
			this.titre = titre;
			this.auteur = auteur;
			this.type = type;
			this.landing = landing;
		}


		public int getIdOeuvre() {
			return idOeuvre;
		}

		public void setIdOeuvre(int idOeuvre) {
			this.idOeuvre = idOeuvre;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getAuteur() {
			return auteur;
		}

		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}

		public int getNbReservation() {
			return nbReservation;
		}

		public void setNbReservation(int nbReservation) {
			this.nbReservation = nbReservation;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public int getLanding() {
			return landing;
		}


		public void setLanding(int landing) {
			this.landing = landing;
		}
		

		public ArrayList<Exemplaire> getExemplairelist() {
			return exemplairelist;
		}

		public void setExemplairelist(ArrayList<Exemplaire> exemplairelist) {
			this.exemplairelist = exemplairelist;
		}


		public ArrayList<Reservation> getReservationlist() {
			return reservationlist;
		}


		public void setReservationlist(ArrayList<Reservation> reservationlist) {
			this.reservationlist = reservationlist;
		}

		/*public ArrayList<Reservation> getReservationlist() {
			return reservationlist;
		}

		public void setReservationlist(ArrayList<Reservation> reservationlist) {
			this.reservationlist = reservationlist;
		}
		*/
	
	}
