package fr.pizzeria.console;

import java.util.Scanner;

public class SupprimerPizzaOptionMenu {
	//afficher le menu
	for (int i = 0; i < pizzas.length; i++) {
		if (pizzas[i] != null) {
			System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
		}
	}
	
	System.out.println("Veillez choisir un pizza à supprimer");
	
	//entrée pizza a supprimer
	Scanner sc5 = new Scanner(System.in);
	String codeSupprimer = sc5.nextLine();
	Pizza pizzaSupprimer = null;
	
	for (int i = 0; i < pizzas.length; i++) {
		if (pizzas[i] != null && codeSupprimer.equals(pizzas[i].code)) {
			pizzas[i] = null;
		}
	}
	
	//afficher le menu
	for (int i = 0; i < pizzas.length; i++) {
		if (pizzas[i] != null) {
			System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
		}
	}
	break;
}
