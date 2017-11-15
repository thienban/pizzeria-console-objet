package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	private IPizzaDao dao;
	
	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() throws SavePizzaException{
		
		//récupérer le tableau Pizza
		Pizza[] pizzas = dao.findAllPizzas();
		// Saisir un pizza
		System.out.println("Veuillez saisir le code");
		Scanner sc1 = new Scanner(System.in);
		String code = sc1.nextLine();
		
		//Vérifier si le nom de pizza existe
		for (int j = 0; j < pizzas.length; j++) {
			if (code.equals(pizzas[j].getCode())) {
			throw new SavePizzaException("Le nom de pizza existe");
			}
		}
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		Scanner sc2 = new Scanner(System.in);
		String nom = sc2.nextLine();
		
		//Vérifier si le nom est remplie
		if(nom.isEmpty()) {
			throw new SavePizzaException("le nom du pizza doit etre remplie");
		}

		System.out.println("Veuillez saisir le prix");
		Scanner sc3 = new Scanner(System.in);
		String prix = sc3.nextLine();
		// conversion de string à double
		double prix1 = Double.parseDouble(prix);
		
		//Vérifier si le prix est positif
		if (prix1<0) {
			throw new SavePizzaException("Le prix de la pizza doit être positif");
		}

		// Enregistrer nouveau pizza dans tableau
		Pizza pizza = new Pizza(0, code, nom, prix1);
		dao.saveNewPizza(pizza);
		
		//afficher la liste pizza 
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + "->" + pizzas[i].getNom() + "(" + pizzas[i].getPrix() + "€" + ")");
			}
		}
		
		return true;
	}
}
