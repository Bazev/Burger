package fr.humanbooster.fx.burger.business;

public class Boisson {
	
	private String nom;
	private float prix;
	private static Long count = 0L;
	private Long id;
	
	public Boisson() {
		id = count++;
	}

	public Boisson(String nom, float prix) {
		this();
		this.nom = nom;
		this.prix = prix;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Boisson [nom=" + nom + ", prix=" + prix + "]";
	}
	
	

}
