package fr.pizzeria.console;

public class ListerPizzasOptionMenu {
	// afficher le menu
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i] != null) {
						System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
					}
				}
}
