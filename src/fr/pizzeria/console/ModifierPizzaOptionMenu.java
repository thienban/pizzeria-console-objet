package fr.pizzeria.console;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}
	
	public boolean execute() throws UpdatePizzaException, PizzaDontMatchException{
		// afficher le menu
		List<Pizza> pizzas = dao.findAllPizzas();
		new ListerPizzasOptionMenu(dao).execute();
		
		// entr�e du code pour changer
		System.out.println("Saisir un code de pizza pour changer");
		Scanner sc = new Scanner(System.in);
		String codeAModifier = sc.nextLine();

		for (Pizza p:pizzas) {
			if (p != null && codeAModifier.equals(p.getCode())) {

				// Saisir un pizza � changer
				System.out.println("Veuillez saisir le code");
				String code2 = sc.nextLine();
				
				//V�rifier si le nom de pizza existe
				checkPizzaCode(code2);
					
				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom1 = sc.nextLine();
				
				//V�rifier si le nom est remplie
				if(nom1.isEmpty()) {
					throw new UpdatePizzaException("le nom du pizza doit etre remplie");
				}

				System.out.println("Veuillez saisir le prix");
				String prix2 = sc.nextLine();
				// conversion de string � double
				double prix3 = Double.parseDouble(prix2);
				
				//V�rifier si le prix est positif
				if (prix3<0) {
					throw new UpdatePizzaException("Le prix de la pizza doit �tre positif");
				}
				// modifier le pizza
				dao.updatePizza(codeAModifier, new Pizza(code2,nom1, prix3));
			}
		}
		return true;
	}
}
