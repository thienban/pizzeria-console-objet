package fr.pizzeria.dao;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;

public interface IPizzaDao {

	// READ
	List<Pizza> findAllPizzas();

	// CREATE
	boolean saveNewPizza(Pizza pizza);

	// UPDATE
	boolean updatePizza(String codePizza, Pizza pizza);

	// DELETE
	boolean deletePizza(String codePizza);
}
