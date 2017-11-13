package fr.pizzeria.console;

//déclaration class pizza
public class Pizza {
	// Stocke id
	int id;
	// Stocke code
	String code;
	// Stocke nom
	String nom;
	// Stocke prix
	double prix;

	//constructeur
	Pizza(int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;

	}
}