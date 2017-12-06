package fr.pizzeria.console;

import fr.pizzeria.model.CategoriePizza.CategoriePizza;

//d�claration class pizza
public class Pizza {
	// Stocke id
	public static int numOfPizzas=0;
	// Stocke code
	@ToString(separateur= " -> ")
	private String code;
	// Stocke nom
	@ToString
	private String nom;
	// Stocke prix
	private double prix;
	private CategoriePizza categorie;
	
	//constructeur
	public Pizza(String code, String nom, double prix,CategoriePizza categorie) {
		numOfPizzas++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
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

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	public String toString () {
		return this.code + this.nom + " (" + this.prix + ") " + this.categorie; 
	}
}