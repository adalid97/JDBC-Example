package com.Concesionario.coches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainCoches {

	public void connectDatabase() {
		try {
			try {
				// Se registra el Driver de Mysql
				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registra el driver de Mysql: " + ex);
			}
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");

			boolean valid = connection.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");

			Scanner s = new Scanner(System.in);

			int opcion;
			do {
				System.out.println("**** MENÚ PRINCIPAL ****\n");
				System.out.println("1. Insertar coche.");
				System.out.println("2. Mostrar coches.");
				System.out.println("3. Actualizar coche");
				System.out.println("4. Eliminar coche.");
				System.out.println("5. Comprar coche.");
				System.out.println("0. Salir.");
				System.out.print("\n\t Escribe el número de la opción (0-5): ");
				opcion = Integer.parseInt(s.nextLine());

				switch (opcion) {
				case 0:
					System.out.println("FIN DEL PROGRAMA.");
					break;
				case 1:
					System.out.println("----INSERTAR COCHE----");
					insertarCoche(connection);
					break;

				case 2:
					System.out.println("----LISTAR COCHES----");
					selectCoches(connection);
					break;

				case 3:
					System.out.println("----ACTUALIZAR COCHE----");
					actualizarCoches(connection);
					break;

				case 4:
					System.out.println("----ELIMINAR COCHE----");
					eliminarCoche(connection);
					break;
				case 5:
					System.out.println("----COMPRAR COCHE----");
					comprarCoche(connection);
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
					break;
				}

			} while (opcion != 0);

		} catch (

		java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}

	}

	public static void main(String[] args) {
		MainCoches javaMySQLBasic = new MainCoches();
		javaMySQLBasic.connectDatabase();

	}

	public void insertarCoche(Connection conn) throws SQLException {
		String sql = "INSERT INTO coches (id, marca, modelo, matricula, motor, fechaMatriculacion, precio) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		Scanner s1 = new Scanner(System.in);

		System.out.print("\tMARCA COCHE: ");
		String marca = s1.next();

		System.out.print("\tMODELO COCHE: ");
		String modelo = s1.next();

		System.out.print("\tMATRÍCULA COCHE: ");
		String matricula = s1.next();

		System.out.print("\tMOTOR COCHE: ");
		String motor = s1.next();

		System.out.print("\tFECHA MATRICULACIÓN COCHE(yyyy-mm-dd): ");
		String fechaMatriculacion = s1.next();

		System.out.print("\tPRECIO COCHE: ");
		float precio = s1.nextFloat();

		statement.setString(1, null);
		statement.setString(2, marca);
		statement.setString(3, modelo);
		statement.setString(4, matricula);
		statement.setString(5, motor);
		statement.setString(6, fechaMatriculacion);
		statement.setFloat(7, precio);

		int rowsInserter = statement.executeUpdate();
		if (rowsInserter > 0) {
			JOptionPane.showMessageDialog(null, "-----Coche Insertado correctamente! -----");
		}
	}

	public void selectCoches(Connection conn) throws SQLException {

		String sql = "SELECT * FROM coches";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			int id = result.getInt(1);
			String marca = result.getString(2);
			String modelo = result.getString(3);
			String matricula = result.getString(4);
			String motor = result.getString(5);
			String fechaMatriculacion = result.getString(6);
			float precio = result.getFloat(7);

			count++;
			System.out.println("\t - " + id + " " + marca + " " + modelo + " " + matricula + " " + motor + " "
					+ fechaMatriculacion + " " + precio + "\n");
		}
		System.out.println("");
	}

	public void actualizarCoches(Connection conn) throws SQLException {
		String sql = "UPDATE coches SET marca=?, modelo=?, matricula=?, motor=?, fechaMatriculacion=?, precio=? WHERE id=?";

		PreparedStatement statement = conn.prepareStatement(sql);

		Scanner s2 = new Scanner(System.in);

		System.out.print("\tID COCHE: ");
		int id = s2.nextInt();

		System.out.print("\tMARCA COCHE: ");
		String marca = s2.next();

		System.out.print("\tMODELO COCHE: ");
		String modelo = s2.next();

		System.out.print("\tMATRÍCULA COCHE: ");
		String matricula = s2.next();

		System.out.print("\tMOTOR COCHE: ");
		String motor = s2.next();

		System.out.print("\tFECHA MATRICULACIÓN COCHE: ");
		String fechaMatriculacion = s2.next();

		System.out.print("\tPRECIO COCHE: ");
		float precio = s2.nextFloat();

		statement.setInt(7, id);
		statement.setString(1, marca);
		statement.setString(2, modelo);
		statement.setString(3, matricula);
		statement.setString(4, motor);
		statement.setString(5, fechaMatriculacion);
		statement.setFloat(6, precio);

		int rowUptade = statement.executeUpdate();
		if (rowUptade > 0) {
			JOptionPane.showMessageDialog(null, "----- Actualizado! -----");
		}

	}

	public void eliminarCoche(Connection conn) throws SQLException {
		String sql = "DELETE FROM coches WHERE id=?";

		Scanner s3 = new Scanner(System.in);

		PreparedStatement statement = conn.prepareStatement(sql);

		System.out.print("\tID COCHE A BORRAR: ");
		int id = s3.nextInt();

		statement.setInt(1, id);

		int rowDeleted = statement.executeUpdate();
		if (rowDeleted > 0) {
			JOptionPane.showMessageDialog(null, "----- Coche Eliminado! -----");
		}

	}

	public void comprarCoche(Connection conn) throws SQLException {

		// REGISTRO DE CLIENTES
		String sql = "INSERT INTO clientes (idCliente, nombre, apellido, direccion) VALUES (?,?,?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);

		Scanner s4 = new Scanner(System.in);

		System.out.print("\tNOMBRE CLIENTE: ");
		String nombre = s4.next();

		System.out.print("\tAPELLIDO CLIENTE: ");
		String apellido = s4.next();

		System.out.print("\tDIRECCIÓN CLIENTE: ");
		String direccion = s4.next();

		statement.setString(1, null);
		statement.setString(2, nombre);
		statement.setString(3, apellido);
		statement.setString(4, direccion);

		int rowsInserter = statement.executeUpdate();
		if (rowsInserter > 0) {
			JOptionPane.showMessageDialog(null, "-----Cliente insertado correctamente!-----");

			// LISTADO DE COCHES
			String sql3 = "SELECT * FROM coches";

			Statement statement3 = conn.createStatement();
			ResultSet result = statement3.executeQuery(sql3);

			while (result.next()) {
				int id = result.getInt(1);
				String marca = result.getString(2);
				String modelo = result.getString(3);
				String matricula = result.getString(4);
				String motor = result.getString(5);
				String fechaMatriculacion = result.getString(6);
				float precio = result.getFloat(7);

				System.out.println("\t - " + id + " " + marca + " " + modelo + " " + matricula + " " + motor + " "
						+ fechaMatriculacion + " " + precio + "\n");
			}

			// SELECCIÓN ASIGNACIÓN Y BORRADO DE COCHE
			System.out.println("\n¿Qué coche desea comprar?");
			int id = s4.nextInt();

			String sql2 = "DELETE FROM coches WHERE id=?";

			PreparedStatement statement2 = conn.prepareStatement(sql2);
			statement2.setInt(1, id);
			int rowDeleted = statement2.executeUpdate();
			if (rowDeleted > 0) {
				JOptionPane.showMessageDialog(null, "----- Coche Comprado!-----");
			}
		}

	}

}