package fr.pizzeria.console;

//déclaration class pizza
public class Pizza {
	// Stocke id
	private int id;
	// Stocke code
	private String code;
	// Stocke nom
	private String nom;
	// Stocke prix
	private double prix;

	//constructeur
	public Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}