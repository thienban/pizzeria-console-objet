package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PizzeriaDaoJdbc {
	public static void main(String[] args) throws Exception {
	Class.forName("org.mariadb.jdbc.Driver");
	Connection myConnection = DriverManager

	.getConnection(« jdbc:mariadb://localhost:3306/pizzeria », « root », « »);

	Statement statement = myConnection.createStatement();
	ResultSet resultat = statement.executeQuery(« SELECT ... »);
}
}
