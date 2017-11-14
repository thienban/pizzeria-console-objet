package fr.pizzeria.dao;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;

public class PizzaDaoTableau implements IPizzaDao {

	Pizza[] pizzas = new Pizza[100];

	public PizzaDaoTableau() {

		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}

	public Pizza[] findAllPizzas() {
		return pizzas;
	}


	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = pizza;
				return true;
			}
		}
		return false;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && codePizza.equals(pizzas[i].getCode())) {
				// modifier le pizza
				pizzas[i] = pizza;
				return true;
			}
		}
		
		return false;
	}

	public boolean deletePizza(String codePizza) {

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && codePizza.equals(pizzas[i].getCode())) {
				pizzas[i] = null;
				return true;
			}
		
		}
		return false;
	}

}
