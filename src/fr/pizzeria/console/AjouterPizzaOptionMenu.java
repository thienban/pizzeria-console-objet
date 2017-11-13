package fr.pizzeria.console;

import java.util.Scanner;

public class AjouterPizzaOptionMenu {

	// Saisir un pizza
				System.out.println("Veuillez saisir le code");
				Scanner sc1 = new Scanner(System.in);
				String code = sc1.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace)");
				Scanner sc2 = new Scanner(System.in);
				String nom = sc2.nextLine();

				System.out.println("Veuillez saisir le prix");
				Scanner sc3 = new Scanner(System.in);
				String prix = sc3.nextLine();
				// conversion de string à double
				double prix1 = Double.parseDouble(prix);

				// Enregistrer nouveau pizza dans tableau
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i] == null) {
						pizzas[i] = new Pizza(i, code, nom, prix1);
						break;
					}
				}
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i] != null) {
						System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
					}
				}
				break;
}
