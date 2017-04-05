package core;

public class Product {
	private int id;
	private int stock;
	private double prix;
	private String nom_Product;
	private String type_Product;
	private String description;

	/**
	 * Méthode qui créer un produit bidon. (N'est normalement jamais utilisée)
	 */
	public Product() {
		this.id = 2;
		this.stock = 3;
		this.prix = 5;
		this.nom_Product = "Steak de Licorne";
		this.type_Product = "Viande";
		this.description = "C'est de la viande quelle est bonne à manger.";
	}

	/**
	 * Créer un produit.
	 * 
	 * @param id
	 * @param stock
	 * @param prix
	 * @param nom_Product
	 * @param type_Product
	 * @param description
	 */
	public Product(int id, int stock, double prix, String nom_Product, String type_Product, String description) {
		this.id = id;
		this.stock = stock;
		this.prix = prix;
		this.nom_Product = nom_Product;
		this.type_Product = type_Product;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}

	public double getPrix() {
		return prix;
	}

	public String getNom_Product() {
		return nom_Product;
	}

	public String getType_Product() {
		return type_Product;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * Méthode interne utilisé pour parsé un produit tirée de la BDD
	 * 
	 * @param s
	 *            champs du produit
	 * @return le produit
	 */
	public static Product parseProduct(String[] s) {
		return new Product(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Float.parseFloat(s[2]), s[3], s[4], s[5]);
	}

}
