package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;

public class PizzaDaoTableau implements IPizzaDao {

	private List<Pizza> pizzas;

	public PizzaDaoTableau() {
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza( "PEP", "P�p�roni", 12.50));
		pizzas.add(new Pizza( "MAR", "Margherita", 14.00));
		pizzas.add(new Pizza( "REIN", "La Reine", 11.50));
		pizzas.add(new Pizza( "FRO", "La 4 fromage", 12.00));
		pizzas.add(new Pizza( "CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza( "SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza( "ORI", "L'orientale", 13.50));
		pizzas.add(new Pizza( "IND", "L'indienne", 14.00));
	}

	public List<Pizza> findAllPizzas() {
		return pizzas;
	}


	public boolean saveNewPizza(Pizza pizza) {
				pizzas.add(pizza);//ajouter pizza 
				return true;
			}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i) != null && codePizza.equals(pizzas.get(i).getCode())) {
				// modifier le pizza
				pizzas.set(i, pizza);
				return true;
			}
		}
		
		return false;
	}

	public boolean deletePizza(String codePizza) {

		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i) != null && codePizza.equals(pizzas.get(i).getCode())) {
				pizzas.remove(i);//supprimer le pizza 
				return true;
			}
		
		}
		return false;
	}

}
