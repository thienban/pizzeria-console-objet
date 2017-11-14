package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() {
		// afficher le menu
		
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + "->" + pizzas[i].getNom() + "(" + pizzas[i].getPrix() + "€" + ")");
			}
		}
		// entrée du code pour changer
		System.out.println("Saisir un code de pizza pour changer");
		Scanner sc = new Scanner(System.in);
		String codeAModifier = sc.nextLine();

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && codeAModifier.equals(pizzas[i].getCode())) {

				// Saisir un pizza à changer
				System.out.println("Veuillez saisir le code");
				String code2 = sc.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom1 = sc.nextLine();

				System.out.println("Veuillez saisir le prix");
				String prix2 = sc.nextLine();
				// conversion de string à double
				double prix3 = Double.parseDouble(prix2);

				// modifier le pizza
				Pizza pizza = new Pizza(i, code2, nom1, prix3);

				dao.updatePizza(codeAModifier, pizza);
			}
		}
		return true;
	}
}
