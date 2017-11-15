package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	private IPizzaDao dao;
	
	public SupprimerPizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() throws DeletePizzaException{
		// afficher le menu
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + "->" + pizzas[i].getNom() + "(" + pizzas[i].getPrix() + "€" + ")");
			}
		}
		
		System.out.println("Veillez choisir un code de pizza à supprimer");
		
		// entrée pizza a supprimer
		Scanner sc = new Scanner(System.in);
		String codeSupprimer = sc.nextLine();
		
		//Vérififer le code pizza existe 
		for (int j = 0; j < pizzas.length; j++) {
			if (!codeSupprimer.equals(pizzas[j].getCode())) {
			throw new DeletePizzaException("Le nom de pizza existe");
			}
		}

		dao.deletePizza(codeSupprimer);
		return true;
	}
}
