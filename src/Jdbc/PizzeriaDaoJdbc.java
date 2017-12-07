package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza.CategoriePizza;

//implemts interface IPizzaDao
public class PizzeriaDaoJdbc implements IPizzaDao {

	Connection conn = null;
	Statement statement = null;

	public PizzeriaDaoJdbc() {
		// charger la pilote MariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Pizza> findAllPizzas() {

		List<Pizza> liste = new ArrayList<>();

		try {

			/* Ouverture d'un Statement */
			statement = conn.createStatement();

			// Execution d'une requete de type READ
			ResultSet resultat = statement.executeQuery("select * from pizza");

			// Pour tout les enregistrements de la table pizza
			while (resultat.next()) {

				/* Récupération des valeurs en base pour une pizza donnée */
				int id = resultat.getInt("id");
				String code = resultat.getString("code");
				String nom = resultat.getString("nom");
				Double prix = resultat.getDouble("Prix");
				CategoriePizza categorie = CategoriePizza.valueOf(resultat.getString("categorie"));

				/* Ajout de cette pizza dans une liste de pizza */
				liste.add(new Pizza(code, nom, prix, categorie));
			}

			/* Fermeture du Statement */
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/* On retourne la liste de pizzas qui contient toutes les pizzas en base !!! */
		return liste;
	}

	public boolean saveNewPizza(Pizza pizza) {
		try {
			// Execution d'une requete de type Create
			PreparedStatement prepStat = conn.prepareStatement("INSERT INTO pizza (code,nom,prix,categorie) VALUES (?,?,?,?)");
			prepStat.setString(1, pizza.getCode());
			prepStat.setString(2, pizza.getNom());
			prepStat.setDouble(3, pizza.getPrix());
			prepStat.setString(4, pizza.getCategorie().toString());
			prepStat.executeUpdate();
			prepStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		try {
			PreparedStatement prepStat = conn.prepareStatement("UPDATE pizza SET code=?, nom = ?, prix = ?, categorie = ? WHERE code = ?");
			prepStat.setString(1, pizza.getCode());
			prepStat.setString(2, pizza.getNom());
			prepStat.setDouble(3, pizza.getPrix());
			prepStat.setString(4, pizza.getCategorie().toString());
			prepStat.setString(5, codePizza);
			prepStat.executeUpdate();
			prepStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePizza(String codePizza) {
		try {
			PreparedStatement prepStat = conn.prepareStatement("DELETE FROM pizza WHERE code=?");
			prepStat.setString(1, codePizza);
			prepStat.executeUpdate();
			prepStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
