package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.UpdatePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	
	public SupprimerPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}
	
	public boolean execute() throws DeletePizzaException, PizzaDontMatchException{
		// afficher la liste des pizzas
		new ListerPizzasOptionMenu(dao).execute();
		System.out.println("Veillez choisir un code de pizza � supprimer");
		
		// entr�e pizza a supprimer
		Scanner sc = new Scanner(System.in);
		String codeSupprimer = sc.nextLine();
		if(checkPizzaCode(codeSupprimer)) {
			dao.deletePizza(codeSupprimer);
		}
				
		return true;
	}
}
