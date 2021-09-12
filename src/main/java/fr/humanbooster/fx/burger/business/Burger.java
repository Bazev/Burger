package fr.humanbooster.fx.burger.business;

/**
 * Cette classe représente le concept de burger
 * 
 * Tout ce que notre client connait se trouve dans le package business
 * 
 * @author fxcote
 *
 */
public class Burger {

	private String nom;
	private float prix;
	private static Long count = 0L;
	private Long id;

	public Burger() {
		id = count++;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Burger(String nom, float prix) {
		this();
		this.nom = nom;
		this.prix = prix;
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
		return "Burger [nom=" + nom + ", prix=" + prix + "]";
	}
	
}