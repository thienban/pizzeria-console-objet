package fr.pizzeria.console;

import fr.pizzeria.dao.IPizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	private IPizzaDao dao;
	
	public ListerPizzasOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}
	
	public boolean execute() {
		
		Pizza[] pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + "->" + pizzas[i].getNom() + "(" + pizzas[i].getPrix() + "€" + ")");
			}
		}
		return true; 
	}
}
