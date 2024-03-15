package com.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOB {
	
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String username = "root";
	String password = "964018";
	String sql="UPDATE `employee` SET `DP`=? WHERE `name`=?";
	String path="D:\\java\\Advance_Java1\\images\\prasad.png";
	
	
	try {
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement statement=con.prepareStatement(sql);
		
		System.out.println("Enter the name: ");
		statement.setString(2, scan.next());
		
		FileInputStream fil= new FileInputStream(path);
		statement.setBinaryStream(1, fil);
		
		int i=statement.executeUpdate();
		System.out.println(i);
		
	} 
	 catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	
	
  }
}



  //Binary Large Object
  //A BLOB is binary large object that can hold a variable amount of data with a maximum length of 65535 characters.
