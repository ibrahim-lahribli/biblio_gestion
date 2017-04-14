package metier;

import java.util.ArrayList;

	
	public class Exemplaire {
		
		private int id;
		private String etat;
		private int idOeuvre;
		private ArrayList<Emprunt>empruntlist;


		public Exemplaire(int idOeuvre,String etat) {
			
			super();
			this.setIdOeuvre(idOeuvre);
			this.etat = etat;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}

		public int getIdOeuvre() {
			return idOeuvre;
		}

		public void setIdOeuvre(int idOeuvre) {
			this.idOeuvre = idOeuvre;
		}

		/*public Oeuvre getOeuvre() {
			return oeuvre;
		}

		public void setOeuvre(Oeuvre oeuvre) {
			this.oeuvre = oeuvre;
		}
		

		/*public ArrayList<Emprunt> getEmpruntlist() {
			return empruntlist;
		}

		public void setEmpruntlist(ArrayList<Emprunt> empruntlist) {
			this.empruntlist = empruntlist;
		}

		public int getIdOeuvre() {
			return oeuvre.getIdOeuvre();
		}

		public void setIdOeuvre(int idOeuvre) {
			idOeuvre = oeuvre.getIdOeuvre();
		}*/
}