package metier;

public class Usager {
	
	private int id;
	public String nom;
	private String prenom;
	
	
	public Usager(int id, String nom, String prenom) {
		
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
