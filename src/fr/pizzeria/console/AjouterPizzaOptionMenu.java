package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	
	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}
	
	public boolean execute() throws SavePizzaException, PizzaDontMatchException{
		
		//r�cup�rer le tableau Pizza
		List<Pizza> pizzas = dao.findAllPizzas();
		// Saisir un pizza
		System.out.println("Veuillez saisir le code");
		Scanner sc1 = new Scanner(System.in);
		String code = sc1.nextLine();
		
		//V�rifier si le nom de pizza existe
		//checkPizzaCode(code);
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		Scanner sc2 = new Scanner(System.in);
		String nom = sc2.nextLine();
		
		//V�rifier si le nom est remplie
		if(nom.isEmpty()) {
			throw new SavePizzaException("le nom du pizza doit etre remplie");
		}

		System.out.println("Veuillez saisir le prix");
		Scanner sc3 = new Scanner(System.in);
		String prix = sc3.nextLine();
		// conversion de string � double
		double prix1 = Double.parseDouble(prix);
		
		//V�rifier si le prix est positif
		if (prix1<0) {
			throw new SavePizzaException("Le prix de la pizza doit �tre positif");
		}

		// Enregistrer nouveau pizza dans tableau
		Pizza pizza = new Pizza( code, nom, prix1);
		dao.saveNewPizza(pizza);
		
		//afficher la liste pizza 
		new ListerPizzasOptionMenu(dao).execute();
		
		return true;
	}
}
