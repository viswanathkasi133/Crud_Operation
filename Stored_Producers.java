package com.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.tap.day2;

public class Stored_Producers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "964018";
		
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			CallableStatement statement =connection.prepareCall("{call count_emp(?,?) }");
			statement.setString(1, scan.next());
			statement.registerOutParameter(2, Types.INTEGER);
			statement.execute();
			int res=statement.getInt(2);

			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
