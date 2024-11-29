package Weather_Map_App;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/*
Date: 10/21/2022

This program is written with the aim of helping users 
to see the weather conditions and the map anywhere they want in real-time.
It could show the user the temperature, wind speed, humidity, map, etc 
of the city that the user enter.
*/

public class Map 
{
	static String html;
	static String weather;
	static String mapFileName="myMap.html";
	static ArrayList<String> weatherInfo = new ArrayList<>(); 
	
	public Map (ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException 
	{


		   String city=weatherInfo.get(0);

		    //A single string data using weatherInfo
		    //											index for weather is 1			index for temp is 2			index for low temp is 3			index for high temp is 4	  index for wind is 5			index for humidity is 6				
		    weather = " " + city.toUpperCase()+ "   | " + weatherInfo.get(1)+ "   | " + weatherInfo.get(2)+ "   | " + weatherInfo.get(3)+ "   | " + weatherInfo.get(4)+ "   | " + weatherInfo.get(5)+ "   | " + weatherInfo.get(6);

		    // write a HTML file
		    writeHTML(weather,city, mapType, zoom);

		    // run html file from java code
		    String url = mapFileName;   // you can find this html file in the project folder
		    File htmlFile = new File(url);
		    Desktop.getDesktop().browse(htmlFile.toURI());
		    
	}

	public static void writeHTML(String weatherNow, String city, String mapType, int zoom) 
	{
		html="<!DOCTYPE html>"
		+ "<html>"
		+ "<body>"
		+ "<h2>"
		+ weatherNow
		+ "</h2>"
		+ "<iframe"
		+ "  width=1200"
		+ "  height=900"
		+ "  style=border:0"
		+ "  loading=lazy"
		+ "  allowfullscreen"
		+ "  referrerpolicy=\"no-referrer-when-downgrade\""
		+ "src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyCYUukRiFAb0GRBao-Wnw7taPV0F0gs6cY&q="+ city +"&zoom="+ zoom +"&maptype=" + mapType+"\""
		+ "</iframe>"
		+ "</body>"
		+ "</html>";
		
		File f= new File (mapFileName);
		  try 
		  {
		     BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		     bw.write(html);
		     bw.close();
		  } 
		  catch (IOException e) 
		  {
		    e.printStackTrace();
		  }
	}

}