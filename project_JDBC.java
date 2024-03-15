package com.project;
import com.tap.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class project_JDBC {
	 
		private static Connection connection;
		private static Statement statement;
		private static PreparedStatement prestatement;

		private static Scanner scan = new Scanner(System.in);
		private static  String url="jdbc:mysql://localhost:3306/jdbc";
	     private static String username="root";
	    private static  String password="964018";

		public static void main(String[] args) {
	      System.out.println("Enter the UserNumber: ");
	      int input=scan.nextInt();
	      if(input==1) {
	    	 SelectQuery(); 
	      }
	      else if(input==2) {
	    	  InsertQuery();
	      }
	      else if(input==3) {
	    	  UpdateQuery();
	      }
	      else if(input==4) {
	    	  DeleteQuery();  
	      }
	      else {
	    	  System.out.println("Enter The Valid Number?.......... ");
	      }
   }
		
		
			//  DELETE QUERY:

		     static void DeleteQuery() {
			String DeleteQuery="DELETE from `employee` WHERE `id`=? ";
			try {
				connection=DriverManager.getConnection(url, username, password);
				prestatement=connection.prepareStatement(DeleteQuery);
				
				System.out.println("Enter the id: ");
				prestatement.setInt(1, scan.nextInt());
				
				int i=prestatement.executeUpdate();
				day2.disply(connection, prestatement, null);
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		     
		     
		     //     UPADET QUERY:
		     
			static void UpdateQuery() {
		    String UpdateQuery="UPDATE `employee` SET `salary`=`salary`+? WHERE `name`=? ";
		    try {
				connection=DriverManager.getConnection(url, username, password);
				prestatement=connection.prepareStatement(UpdateQuery);
				
				System.out.println("Enter the salary: ");
				prestatement.setInt(1, scan.nextInt());
				
				System.out.println("Enter the name: ");
				prestatement.setString(2, scan.next());
				int i=prestatement.executeUpdate();
				
				System.out.println(i);
				day2.disply(connection, prestatement, null);
				
			}
		    catch (SQLException e) {
				e.printStackTrace();
			}
		}

			//    INSERT QUERY:
			
			
		static void InsertQuery() {
			String insertQuery="INSERT into `employee` (`id`, `name`, `email`, `dept`, `salary`) value(?,?,?,?,?)";   
			try {
				connection=DriverManager.getConnection(url, username, password);
				prestatement=connection.prepareStatement(insertQuery);
				do {
					
					System.out.println("Enter the id: ");
					int id=scan.nextInt();
					
					System.out.println("Enter the name: ");
					String name=scan.next();
					
					System.out.println("Enter the email: ");
					String email=scan.next();
					
					System.out.println("Enter the dept: ");
					String dept=scan.next();
					
					System.out.println("Enter the salary: ");
					int salary=scan.nextInt();
					
					prestatement.setInt(1, id);
					prestatement.setString(2, name);
					prestatement.setString(3, email);
					prestatement.setString(4, dept);
					prestatement.setInt(5, salary);
					
					int i=prestatement.executeUpdate();
					System.out.println("Enter the more employees(yes/no)");
					
				} 
				while (scan.next().equalsIgnoreCase("yes"));
				 System.out.println();
					day2.disply(connection, statement, null);
					
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

 
		   
		 //    SELECT QUERY: 
		
		   
		static void SelectQuery() {
			 
		      String SelectQuery="SELECT * from `employee`";
		      
		       try {
				 connection= DriverManager.getConnection(url, username, password);
				 Statement statement=connection.createStatement();
				 ResultSet res=statement.executeQuery(SelectQuery);
				 
				System.out.println("-------------------------------------------------------------");
				
				 while(res.next()) {
					 
					 int id=res.getInt("id");
					 String name=res.getString("name");
					 String email=res.getString("email");
					 String dept=res.getString("dept");
					 int salary =res.getInt("salary");
					 
					 System.out.printf("|%-3d | %-10s | %-18s | %-10s | %d |\n", id, name,email,dept,salary);
					 
				 }
					System.out.println("-------------------------------------------------------------");

			} 
		       catch (SQLException e) {
				e.printStackTrace();
			}
		 }	
   }


