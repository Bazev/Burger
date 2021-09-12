package fr.humanbooster.fx.burger.business;

import java.util.List;

public class Commande {
	
	private boolean surPlace;
	private Burger burger;
	private Boisson boisson;
	private Accompagnement accompagnement;
	private List<Sauce> sauces;
	private String numeroCB;
	private String crypto;
	private int annee;
	private byte mois;
	private String remarque;
	private static Long count = 0L;
	private Long id;
	
	
	
	public Commande() {
		id = count++;
	}





	public Commande(boolean surPlace, Burger burger, Boisson boisson, Accompagnement accompagnement, List<Sauce> sauces,
			String numeroCB, String crypto, int annee, byte mois, String remarque) {
		this();
		this.surPlace = surPlace;
		this.burger = burger;
		this.boisson = boisson;
		this.accompagnement = accompagnement;
		this.sauces = sauces;
		this.numeroCB = numeroCB;
		this.crypto = crypto;
		this.annee = annee;
		this.mois = mois;
		this.remarque = remarque;

	}





	public String getRemarque() {
		return remarque;
	}





	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}





	public boolean isSurPlace() {
		return surPlace;
	}


	public void setSurPlace(boolean surPlace) {
		this.surPlace = surPlace;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Burger getBurger() {
		return burger;
	}


	public void setBurger(Burger burger) {
		this.burger = burger;
	}


	public Boisson getBoisson() {
		return boisson;
	}


	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}


	public Accompagnement getAccompagnement() {
		return accompagnement;
	}


	public void setAccompagnement(Accompagnement accompagnement) {
		this.accompagnement = accompagnement;
	}


	public List<Sauce> getSauces() {
		return sauces;
	}


	public void setSauces(List<Sauce> sauces) {
		this.sauces = sauces;
	}


	public String getNumeroCB() {
		return numeroCB;
	}


	public void setNumeroCB(String numeroCB) {
		this.numeroCB = numeroCB;
	}


	public String getCrypto() {
		return crypto;
	}


	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public int getMois() {
		return mois;
	}


	public void setMois(byte mois) {
		this.mois = mois;
	}





	@Override
	public String toString() {
		return "Commande [surPlace=" + surPlace + ", burger=" + burger + ", boisson=" + boisson + ", accompagnement="
				+ accompagnement + ", sauces=" + sauces + ", numeroCB=" + numeroCB + ", crypto=" + crypto + ", annee="
				+ annee + ", mois=" + mois + ", remarque=" + remarque + ", id=" + id + "]";
	}



	


}
