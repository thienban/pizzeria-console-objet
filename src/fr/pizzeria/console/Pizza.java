package fr.pizzeria.console;

//d�claration class pizza
public class Pizza {
	// Stocke id
	public static int numOfPizzas=0;
	// Stocke code
	private String code;
	// Stocke nom
	private String nom;
	// Stocke prix
	private double prix;

	//constructeur
	public Pizza(String code, String nom, double prix) {
		numOfPizzas++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		System.out.println("il ya " + Pizza.numOfPizzas + " pizzas");
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