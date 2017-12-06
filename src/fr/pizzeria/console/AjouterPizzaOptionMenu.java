package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza.CategoriePizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}

	public boolean execute() throws SavePizzaException, PizzaDontMatchException {

		// rï¿½cupï¿½rer le tableau Pizza
		List<Pizza> pizzas = dao.findAllPizzas();
		// Saisir un pizza
		System.out.println("Veuillez saisir le code");
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();

		// Vï¿½rifier si le nom de pizza existe
		// checkPizzaCode(code);

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();

		// Vï¿½rifier si le nom est remplie
		if (nom.isEmpty()) {
			throw new SavePizzaException("le nom du pizza doit etre remplie");
		}

		System.out.println("Veuillez saisir le prix");
		String prix = sc.nextLine();
		// conversion de string ï¿½ double
		double prix1 = Double.parseDouble(prix);

		// Vï¿½rifier si le prix est positif
		if (prix1 < 0) {
			throw new SavePizzaException("Le prix de la pizza doit ï¿½tre positif");
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
			categorie = CategoriePizza.POISSON;
			;
			break;
		case "3":
			categorie = CategoriePizza.SANS_VIANDE;
			break;
		default:
			categorie = CategoriePizza.VIANDE;
		}
		// Enregistrer nouveau pizza dans tableau
		Pizza pizza = new Pizza(code, nom, prix1, categorie);
		dao.saveNewPizza(pizza);

		// afficher la liste pizza
		new ListerPizzasOptionMenu(dao).execute();

		return true;
	}
}
