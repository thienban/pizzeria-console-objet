package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	private IPizzaDao dao;
	
	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() {
		
		// Saisir un pizza
		System.out.println("Veuillez saisir le code");
		Scanner sc1 = new Scanner(System.in);
		String code = sc1.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		Scanner sc2 = new Scanner(System.in);
		String nom = sc2.nextLine();

		System.out.println("Veuillez saisir le prix");
		Scanner sc3 = new Scanner(System.in);
		String prix = sc3.nextLine();
		// conversion de string à double
		double prix1 = Double.parseDouble(prix);

		// Enregistrer nouveau pizza dans tableau
		Pizza pizza = new Pizza(0, code, nom, prix1);
		dao.saveNewPizza(pizza);
		
		//afficher la liste pizza 
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + "->" + pizzas[i].getNom() + "(" + pizzas[i].getPrix() + "€" + ")");
			}
		}
		
		return true;
	}
}
