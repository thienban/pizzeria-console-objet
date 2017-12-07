package fr.pizzeria.console;

import java.lang.reflect.Field;

import fr.pizzeria.model.CategoriePizza.CategoriePizza;

//dï¿½claration class pizza
public class Pizza {
	// Stocke id
	private int id;
	// Stocke code
	@ToString(uppercase= true,symbol="=>")
	private String code;
	// Stocke nom
	@ToString()
	private String nom;
	// Stocke prix
	@ToString(symbol = " €", surroundedBefore = "( ", surroundedAfter = " )")
	private double prix;
	@ToString()
	private CategoriePizza categorie;
	
	//constructeur
	public Pizza(String code, String nom, double prix,CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
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
	public String toString() {
		String pizzaString = "";
		for (Field attribute : this.getClass().getDeclaredFields()) {
			if (attribute.isAnnotationPresent(ToString.class)) {
				ToString tostr = (ToString) attribute.getAnnotation(ToString.class);
				try {
					String fieldValue = attribute.get(this).toString();
					if (tostr.uppercase()) {
						fieldValue = fieldValue.toUpperCase();
					}
					fieldValue = tostr.surroundedBefore() + fieldValue + tostr.symbol() + tostr.surroundedAfter();
					pizzaString += fieldValue;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return pizzaString.trim().replace("_", " ");
	}
}