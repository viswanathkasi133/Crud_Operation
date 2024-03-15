package com.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "964018";
		
		String sql="UPDATE `employee` SET `Intro` =? WHERE `name`=? ";
		String path="D:\\java\\Advance_Java1\\images\\prasad.txt";
		
		try {
			Connection con=DriverManager.getConnection(url, username, password);
			CallableStatement statement=con.prepareCall(sql);
			System.out.println("Enter the name: ");
			statement.setString(2, scan.next());
			FileReader fr= new FileReader(path);
			statement.setCharacterStream(1, fr);
			int i=statement.executeUpdate();
			System.out.println(i);
			
		} 
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

//character large object
//A CLOB (character large object) value can be up to 2,147,483,647 characters long. 
