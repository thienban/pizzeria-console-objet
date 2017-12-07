package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Jdbc.PizzeriaDaoJdbc;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.PizzaDontMatchException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class Menu {

	public void afficher() {

		// tableau pizzas
		IPizzaDao dao = new PizzeriaDaoJdbc();

		boolean continuer = true;
		Scanner sc = new Scanner(System.in);
		while (continuer) {
			// affichage menu
			System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
					+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre � jour une pizza\r\n"
					+ "4. Supprimer une pizza\r\n" + "99. Sortir");

			// lire entr�e
			String choix = sc.nextLine();

			// les choix de l'utilisateur
			Map<String, OptionMenu> choixMenu = new HashMap<String, OptionMenu>();
			choixMenu.put("1", new ListerPizzasOptionMenu(dao));
			choixMenu.put("2", new AjouterPizzaOptionMenu(dao));
			choixMenu.put("3", new ModifierPizzaOptionMenu(dao));
			choixMenu.put("4", new SupprimerPizzaOptionMenu(dao));

			try {
				OptionMenu action = choixMenu.get(choix);
				if (action != null) {
					action.execute();
				} else if (choix.equals("99")) {
					continuer = false;
					System.out.println("Bye !");
				} else {
					System.out.println("Mauvaise valeur");
				}
			} catch (StockageException e1) {
				System.out.println(e1.getMessage());// afficher le message erreur
			} catch (PizzaDontMatchException e1) {
				System.out.println(e1.getMessage());// afficher le message erreur
			}
		}
		sc.close();
	}
}
