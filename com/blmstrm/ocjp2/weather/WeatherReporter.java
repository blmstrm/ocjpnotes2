package com.blmstrm.ocjp2.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class WeatherReporter {
	
	private String dayOfWeek;
	
	{
		Calendar calendar = Calendar.getInstance();

		int day = calendar.get(Calendar.DAY_OF_WEEK); 

		dayOfWeek = "";
		
		switch(day){
		case Calendar.SUNDAY:
			dayOfWeek = "\"Sunday\"";
			break;
		case Calendar.MONDAY:
			dayOfWeek = "\"Monday\"";
			break;
		case Calendar.TUESDAY:
			dayOfWeek = "\"Tuesday\"";
			break;
		case Calendar.WEDNESDAY:
			dayOfWeek = "\"Wednesday\"";
			break;
		case Calendar.THURSDAY:
			dayOfWeek = "\"Thursday\"";
			break;
		case Calendar.FRIDAY:
			dayOfWeek = "\"Friday\"";
			break;
		case Calendar.SATURDAY:
			dayOfWeek = "\"Saturday\"";
			break;
		}
		
	}
	

	private WeatherFetcher fetcher;

	private String connUrl = "jdbc:mysql://localhost:3306/";	

	private String db = "ocjp";

	private String username = "root";
	private String password = "root";


	public WeatherReporter(){

		this.fetcher = new WeatherFetcher();

		new Thread(fetcher).start();
	}


	class WeatherFetcher implements Runnable{

		@Override
		public void run() {

			ArrayList <String> forecast = new ArrayList<String>();
			String interestingDay ="";

			Process p;
			InputStream input;
			InputStreamReader reader;
			BufferedReader buffReader;

			String []  splitDay;
			String line;

			Connection connection = null;

			Statement statement;
			ResultSet rslt;

			String weekday;
			String weather;
			int temp;

			try {

				while(true){

					p = Runtime.getRuntime().exec("weather --forecast --no-conditions --city=pine_bluff --st=ar -m");
					
					input = p.getInputStream();
					reader = new InputStreamReader(input);
					buffReader = new BufferedReader(reader);
					line = null;

					while((line = buffReader.readLine())!=null){
						forecast.add(line.replaceAll(",|[...]|high|Low|chance|of|precipitation|Mostly|\\s{2,}|\\d%","").trim());
					}
					
					interestingDay = forecast.get(2);
					splitDay = interestingDay.split(" ");

					try{
						connection = DriverManager.getConnection(connUrl+db,username,password);

					}catch(Exception e){
						System.out.println("The weather is not on right now. The reason is: "+e);
					}

					try {
					
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						
						rslt = statement.executeQuery("SELECT * FROM weather WHERE weekday="+dayOfWeek);
						
						while(rslt.next()){
							rslt.deleteRow();
						}
						
						rslt = statement.executeQuery("SELECT * FROM weather");

						weekday = splitDay[0];
						weather = splitDay[2];
						temp = Integer.parseInt(splitDay[4]);

						rslt.moveToInsertRow();
						rslt.updateString("weekday", weekday);
						rslt.updateString("weather", weather);
						rslt.updateInt("temp", temp);
						rslt.insertRow();
						rslt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

					p.waitFor();

					Thread.sleep(600_000);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public String getWeather(){

		Connection connection = null;
		Statement statement;
		ResultSet rslt;
		String returnString = "";

		try {

			connection = DriverManager.getConnection(connUrl+db,username,password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rslt = statement.executeQuery("SELECT * FROM weather WHERE weekday="+dayOfWeek);
			
			while(rslt.next()){
				returnString += rslt.getString("weekday")+" "+rslt.getString("weather")+" "+rslt.getInt("temp")+"\n";
			}

			rslt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnString;
	}
}
