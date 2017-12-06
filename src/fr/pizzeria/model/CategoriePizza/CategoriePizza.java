package fr.pizzeria.model.CategoriePizza;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String value; 
	private CategoriePizza(String value) {
		this.value = value;
	}
}
