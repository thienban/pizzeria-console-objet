package fr.pizzeria.console;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class OptionMenu {
	public abstract boolean execute() throws StockageException;
}

