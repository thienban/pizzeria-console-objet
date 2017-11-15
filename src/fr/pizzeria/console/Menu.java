package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class Menu {

	public void afficher() {
		
				// tableau pizzas
				PizzaDaoTableau dao = new PizzaDaoTableau();
				
				boolean continuer = true;
				while(continuer)
				{
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
						try {
						ajouter.execute();
						} catch (SavePizzaException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case "3":
						
						ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(dao);
						try {
							modifier.execute();
						} catch (UpdatePizzaException e) {
							System.out.println(e.getMessage());//afficher le message erreur
						}
	
						break;
						
					case "4":
						SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(dao);
						try {
						supprimer.execute(); 
						} catch (DeletePizzaException e) {
							System.out.println(e.getMessage());
						}
						break;
					case "99":
						System.out.println("Au revoir");
						continuer = false;
					}
				}
	}
}
