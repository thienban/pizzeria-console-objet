package fr.pizzeria.console;

import java.util.Scanner;

public class ModifierPizzaOptionMenu {
	// afficher le menu
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i] != null) {
						System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
					}
				}
				// entrée du code pour changer
				System.out.println("Saisir un code de pizza pour changer");
				Scanner sc4 = new Scanner(System.in);
				String codeAModifier = sc4.nextLine();

				Pizza pizzaAModifier = null;
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i] != null && codeAModifier.equals(pizzas[i].code)) {

						// Saisir un pizza à changer
						System.out.println("Veuillez saisir le code");
						Scanner sc5 = new Scanner(System.in);
						String code2 = sc5.nextLine();

						System.out.println("Veuillez saisir le nom (sans espace)");
						Scanner sc6 = new Scanner(System.in);
						String nom1 = sc6.nextLine();

						System.out.println("Veuillez saisir le prix");
						Scanner sc7 = new Scanner(System.in);
						String prix2 = sc7.nextLine();
						// conversion de string à double
						double prix3 = Double.parseDouble(prix2);

						// modifier le pizza
						pizzas[i] = new Pizza(i, code2, nom1, prix3);

						// afficher le menu
						for (int j = 0; j < pizzas.length; j++) {
							if (pizzas[j] != null) {
								System.out
										.println(pizzas[j].code + "->" + pizzas[j].nom + "(" + pizzas[j].prix + "€" + ")");
							}
						}
					}
				}
}
