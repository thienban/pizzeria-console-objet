package fr.pizzeria.dao;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();

	boolean saveNewPizza(Pizza pizza);

	boolean updatePizza(String codePizza, Pizza pizza);

	boolean deletePizza(String codePizza);
}
