package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	/**
	 * CREATION OF THE DATABASE
	 */
	public static Connection connection = null;
	static {
		System.err.println("CONNECTION TO THE DATABASE...");
		try {
			Class.forName("org.postgresql.Driver");
			System.err.println("DRIVER OK");
			connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-107-20-149-243.compute-1.amazonaws.com:5432/dd92iroqctbp9?sslmode=require", "wcljokynvaoaaz", "bc24d05d2f1abca159a6fd87ee7764acd72919e19a6314d8bdca27dcb2e12567");
			//test22
			
			System.err.println("CONNECTION OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Allow the user to search a product within the database
	 * 
	 * @param type
	 * @return the product(s) wanted by the user
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/product")
	public Product readBookmark(@RequestParam(value = "type", defaultValue = "none") String type) {
		return new Product();
		/*
		String requete;
		if (type.equals("none")) {
			requete = "SELECT * FROM product";
		} else {
			requete = "SELECT * FROM product WHERE type_product ILIKE '" + type + "'";
		}
		ResultSet resultats = null;

		System.out.println("Requete: " + requete);

		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(requete);
			ResultSetMetaData rsmd = resultats.getMetaData();
			int nbCols = rsmd.getColumnCount();

			String product = "";
			String[] productDesc;
			ArrayList<Product> listToSend = new ArrayList<Product>();
			while (resultats.next()) {
				for (int i = 1; i <= nbCols; i++)
					product += resultats.getString(i) + "/";

				productDesc = product.split("/");
				listToSend.add(Product.parseProduct(productDesc));
				product = "";
			}

			return listToSend;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;*/
	}

	/**
	 * Permet d'inséré un produit dans la base de données
	 * 
	 * @param input
	 * @return the json file passed
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/product")
	public Product addProduct(@RequestBody Product input) {
		System.out.println("Coucou: " + input);
		try {

			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Product (id, stock, prix, nom_product, type_product, descrption) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");
			statement.setInt(1, input.getId());
			statement.setInt(2, input.getStock());
			statement.setDouble(3, input.getPrix());
			statement.setString(4, input.getNom_Product());
			statement.setString(5, input.getType_Product());
			statement.setString(6, input.getDescription());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return input;
	}

}
