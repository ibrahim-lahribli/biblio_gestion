package metier;

public class Emprunt {
	
	private int ID;
private int yassine;
	private int ExemplaireID;
	private int UsagerID;
	private String DateEmprunt;
	private String DateRetour;
	private String DateRetourAnnonce;
	
	
	public Emprunt(int exemplaireID, int usagerID, String dateEmprunt,
			String dateRetourAnnonce) {
		super();
		ExemplaireID = exemplaireID;
		UsagerID = usagerID;
		DateEmprunt = dateEmprunt;
		DateRetourAnnonce = dateRetourAnnonce;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getExemplaireID() {
		return ExemplaireID;
	}


	public void setExemplaireID(int exemplaireID) {
		ExemplaireID = exemplaireID;
	}


	public int getUsagerID() {
		return UsagerID;
	}


	public void setUsagerID(int usagerID) {
		UsagerID = usagerID;
	}


	public String getDateEmprunt() {
		return DateEmprunt;
	}


	public void setDateEmprunt(String dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}


	public String getDateRetour() {
		return DateRetour;
	}


	public void setDateRetour(String dateRetour) {
		DateRetour = dateRetour;
	}


	public String getDateRetourAnnonce() {
		return DateRetourAnnonce;
	}


	public void setDateRetourAnnonce(String dateRetourAnnonce) {
		DateRetourAnnonce = dateRetourAnnonce;
	}
	
	
	
	
	
	

}
