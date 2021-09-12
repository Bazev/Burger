package fr.humanbooster.fx.burger.business;

public class Sauce {
	
	private String nom;
	private static Long count = 0L;
	private Long id;
	
	public Sauce() {
		id = count++;
	}

	public Sauce(String nom) {
		this();
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Sauce [nom=" + nom + "]";
	}
	
	
	

}
