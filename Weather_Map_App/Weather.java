package Weather_Map_App;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
/*
Date: 10/21/2022

This program is written with the aim of helping users 
to see the weather conditions and the map anywhere they want in real-time.
It could show the user the temperature, wind speed, humidity, map, etc 
of the city that the user enter.
*/

public class Weather 
{
	private static ArrayList<String> weatherInfo = new ArrayList<>(); //to send the weather info. to google API
	
	static String weatherNow, tempNow, tempLow, tempHigh, windSpeed, humidity;
	
	
	
	public static boolean CityWeather (String cityName) throws Exception 
	{
		boolean validCityName=false;

		try 
		{
			//Create URL 
		String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
		String secondPartURL ="&appid=e8edf3c9b478337dbf74265d31938279"; 
		String theURL = firstPartURL + cityName + secondPartURL;
			
		URL url = new URL(theURL); 
			///Reads information from URL    
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
			//Read JSON file. All the data for the city is stored in “myObject"
		JSONObject myObject = (JSONObject)jsonParser.parse(br); 
	
		
			//1. Add City Name to the data structure 
		 weatherInfo.add(cityName);
		
		 	// 2. City Weather 
		 	JSONArray weatherArray = (JSONArray) myObject.get("weather");
		 	JSONObject w = (JSONObject) weatherArray.get(0);
		// get weather info from w
		 	weatherNow =(String) w.get("description");
		// add weather info to the data structure 
		 	weatherInfo.add(weatherNow);    
		          
		 	// 3. TempNow  
		// get temp from myObject
		 	double cityTemp = (double)((JSONObject) myObject.get("main")).get("temp");
		 	cityTemp = ((cityTemp - 273.15)*9)/5 + 32;///convert to Fahrenheit;
		 	tempNow="temp: "+ String.format("%.1f", cityTemp)+"\u00B0";
		// add temp to the data structure 
		 	weatherInfo.add(tempNow);  
		
		 	//4. TempMin
		// get temp_min
			double cityTempMin = (double)((JSONObject) myObject.get("main")).get("temp_min");
			cityTempMin = ((cityTempMin - 273.15)*9)/5 + 32;///convert to Fahrenheit;
			tempLow="low: "+ String.format("%.1f", cityTempMin)+"\u00B0";
		// add temp_min
			weatherInfo.add(tempLow);  

			//5. TempMax
		// get temp_max
			double cityTempMax = (double)((JSONObject) myObject.get("main")).get("temp_max");
			cityTempMax = ((cityTempMax - 273.15)*9)/5 + 32;///convert to Fahrenheit;
			tempHigh ="high: "+ String.format("%.1f", cityTempMax)+"\u00B0";
		// add temp_max
			weatherInfo.add(tempHigh);  
		
			//6. Wind
		// get Wind
			double cityWind = (double)((JSONObject) myObject.get("wind")).get("speed");
			windSpeed ="wind: "+ cityWind + "mph";
		// add Wind	
			weatherInfo.add(windSpeed);
			
			//7. Humidity
		// get Humidity
			long cityHumidity = (long)((JSONObject) myObject.get("main")).get("humidity");
			humidity ="humidity: "+ cityHumidity + "%";
		// add Wind	
				weatherInfo.add(humidity);
			
			validCityName = true;
		}
		catch (Exception ex)
		{
			validCityName = false;
		}
		return validCityName;
		
	}
	
	public static ArrayList <String> getCityWeatherNow()
	{
		return weatherInfo;
	}
}