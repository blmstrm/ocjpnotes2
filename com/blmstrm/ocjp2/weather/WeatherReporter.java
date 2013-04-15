package com.blmstrm.ocjp2.weather;

import java.sql.Connection;
import java.sql.DriverManager;

public class WeatherReporter {
		
	{

	String connUrl = "jdbc:mysql://localhost:3306/";	
	
	String db = "ocjp";
	
	String username = "root";
	String password = "root";
		
	try(Connection connection = DriverManager.getConnection(connUrl+db,username,password)){
		}catch(Exception e){
		System.out.println("The weather is not on right now. The reason is: "+e);
	}
	
	
	}
}
