package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	private IPizzaDao dao;
	
	public SupprimerPizzaOptionMenu(IPizzaDao dao) {
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
		
		System.out.println("Veillez choisir un pizza à supprimer");
		
		// entrée pizza a supprimer
		Scanner sc5 = new Scanner(System.in);
		String codeSupprimer = sc5.nextLine();
		dao.deletePizza(codeSupprimer);
		return true;
	}
}
