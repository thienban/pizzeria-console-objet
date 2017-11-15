package fr.pizzeria.console;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() throws UpdatePizzaException{
		// afficher le menu
		
		List<Pizza> pizzas = dao.findAllPizzas();
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
				
				//Vérifier si le nom de pizza existe
				for (int j = 0; j < pizzas.length; j++) {
					if (code2.equals(pizzas[i].getCode())) {
					throw new UpdatePizzaException("Le nom de pizza existe");
					}
				}
					
				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom1 = sc.nextLine();
				
				//Vérifier si le nom est remplie
				if(nom1.isEmpty()) {
					throw new UpdatePizzaException("le nom du pizza doit etre remplie");
				}

				System.out.println("Veuillez saisir le prix");
				String prix2 = sc.nextLine();
				// conversion de string à double
				double prix3 = Double.parseDouble(prix2);
				
				//Vérifier si le prix est positif
				if (prix3<0) {
					throw new UpdatePizzaException("Le prix de la pizza doit être positif");
				}
				// modifier le pizza
				Pizza pizza = new Pizza(i, code2, nom1, prix3);

				dao.updatePizza(codeAModifier, pizza);
			}
		}
		return true;
	}
}
