package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;

public class Menu {
	
	public void afficher() {
		
		// tableau pizzas
				PizzaDaoTableau dao = new PizzaDaoTableau();

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
					
					ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(dao);
					lister.execute();
					break;
				case "2":
					AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(dao);
					ajouter.execute();
					break;
				case "3":
					ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(dao);
					modifier.execute();

					break;
					
				case "4":
					SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(dao);
					supprimer.execute(); 
					break;
				case "99":
					System.out.println("Au revoir");
					System.exit(0);
				}

	}
}
