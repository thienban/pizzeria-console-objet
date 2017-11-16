package fr.pizzeria.console;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class OptionMenu {
	protected IPizzaDao dao;
	
	public abstract boolean execute() throws StockageException, PizzaDontMatchException;
	OptionMenu (IPizzaDao dao) {
		this.dao = dao;
	}
	
	protected boolean checkPizzaCode(String pizzaCode) throws PizzaDontMatchException {
		// TODO : verifier que pizzaCode est un code qui existe
		boolean verdict = !dao.findAllPizzas().stream().map((p)->{
			//System.out.println("ici " + p.getCode());
			return p.getCode();})
				.noneMatch(c->c.equals(pizzaCode));
		if(!verdict) {
			throw new PizzaDontMatchException("le code n'existe pas ! ");
		}
		return verdict;
	}
}

