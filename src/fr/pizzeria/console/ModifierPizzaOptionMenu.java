package fr.pizzeria.console;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza.CategoriePizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}

	public boolean execute() throws UpdatePizzaException, PizzaDontMatchException {
		// afficher le menu
		List<Pizza> pizzas = dao.findAllPizzas();
		new ListerPizzasOptionMenu(dao).execute();

		// entrï¿½e du code pour changer
		System.out.println("Saisir un code de pizza pour changer");
		Scanner sc = new Scanner(System.in);
		String codeAModifier = sc.nextLine();

		for (Pizza p : pizzas) {
			if (p != null && codeAModifier.equals(p.getCode())) {

				// Saisir un pizza ï¿½ changer
				System.out.println("Veuillez saisir le code");
				String code2 = sc.nextLine();

				// Vï¿½rifier si le nom de pizza existe
				checkPizzaCode(code2);

				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom1 = sc.nextLine();

				// Vï¿½rifier si le nom est remplie
				if (nom1.isEmpty()) {
					throw new UpdatePizzaException("le nom du pizza doit etre remplie");
				}

				System.out.println("Veuillez saisir le prix");
				String prix2 = sc.nextLine();
				// conversion de string ï¿½ double
				double prix3 = Double.parseDouble(prix2);

				// Vï¿½rifier si le prix est positif
				if (prix3 < 0) {
					throw new UpdatePizzaException("Le prix de la pizza doit ï¿½tre positif");
				}
				// Saisir la catégorie Pizza
				System.out.println(
				"Veuillez saisir la catégorie du pizza (1 pour sans Viande, 2 pour Poisson, 3 pour sans viande");
				String choixCategorie = sc.nextLine();
				CategoriePizza categorie;
				switch (choixCategorie) {
				case "1": 
					categorie = CategoriePizza.VIANDE;
					break;
				case "2":
					categorie = CategoriePizza.POISSON;;
					break;
				case "3":
					categorie = CategoriePizza.SANS_VIANDE;
					break;
				default:
					categorie = CategoriePizza.VIANDE;
				}

				// modifier le pizza
				dao.updatePizza(codeAModifier, new Pizza(code2, nom1, prix3, categorie));
			}
		}
		return true;
	}
}
