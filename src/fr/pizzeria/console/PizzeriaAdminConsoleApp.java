package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] arg) {
		
		// tableau pizzas
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);

		// affichage menu
		System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
				+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre à jour une pizza\r\n" + "4. Supprimer une pizza\r\n"
				+ "99. Sortir");

		// lire entrée
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();

		// les choix de l'utilisateur
		switch (choix) {
		case "1":
			for (int i = 0; i < pizzas.length; i++) {
				if (pizzas[i] != null) {
					System.out.println(pizzas[i].code + "->" + pizzas[i].nom + "(" + pizzas[i].prix + "€" + ")");
				}
			}
			break;
		case "2":
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
		case "3":
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

			break;
			
		case "4":
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
			
		case "99":
			System.out.println("Au revoir");
			System.exit(0);
			break;
		}

	}
}
