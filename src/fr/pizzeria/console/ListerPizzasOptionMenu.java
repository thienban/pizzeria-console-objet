package fr.pizzeria.console;

import fr.pizzeria.dao.IPizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {
		
	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
	}
	
	public boolean execute() {
		for(Pizza p:dao.findAllPizzas()) {
			if(p!=null) System.out.println(p);
		}
		return true; 
	}
}
