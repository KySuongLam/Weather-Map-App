package Weather_Map_App;
import java.util.Scanner;
import java.util.*;
/*
Date: 10/21/2022

This program is written with the aim of helping users 
to see the weather conditions and the map anywhere they want in real-time.
It could show the user the temperature, wind speed, humidity, map, etc 
of the city that the user enter.
*/

public class myWeatherApp 
{

	static Scanner input = new Scanner(System.in);

	 private static ArrayList<String> weatherInfo = new ArrayList<>();
	 static String mapType;
	 static int zoom;

	 
	public static void main(String[] args) throws Exception 
	{
		System.out.println("Welcome to Weather 211 - Fall 2022");
		System.out.println();
		   
		inputCityName();
		getWeatherInfo();
	}
	
	public static void inputCityName() throws Exception
	{     
	     boolean validCityName=false; 
	     while (!validCityName) 
	    {
	    	// ask for city name
	       System.out.println("Input a city name:");
	       String city = input.nextLine();
	       System.out.println();
	    
	       boolean valid =  Weather.CityWeather(city);
	    
	      if (valid) 
	      { 
	         // ask for map type (roadmap, satellite)
	    	  System.out.println("Select map type:  1) roadmap  2) satellite");
	    	 int choice = input.nextInt();
	    	 if (choice==1)
	    	 {
	    		 mapType = "roadmap";
	    	 }else
	    	 {
	    		 mapType = "satellite";
	    	 }
	    	 
	         // ask for zoom level (0~21)
	    	  System.out.println("Select zoom level of the map:  0 ~ 21 (default=14)");  
	    	  zoom = input.nextInt();
	    	  
	    	  
	         System.out.println("Current Weather [" + city +"]\n");
	        break;
	      } else 
	      {
	       System.out.println("Invalid city name. Type again.\n"); 
	      } 
	     }   
	 }
	
	public static void getWeatherInfo() throws Exception 
	{
		   weatherInfo = Weather.getCityWeatherNow();
		 
		   // print text version
		   for (int i=0; i<weatherInfo.size(); i++) 
		   {
		      System.out.println(weatherInfo.get(i));
		   }
		 
		  // call Map211
		  new Map(weatherInfo, mapType, zoom);	  
	}
}