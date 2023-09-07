package Project2;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestAPIkey {
    // your key here
    static String APIKey="AIzaSyBOlGUsupAAco_xp_o9tmBq2P1pnlOlvGM";
    static String html;  

  public static void main(String[] args) throws IOException {
    writeHTML();
    runHTML();
  }

 public static void writeHTML() {
     html= "<iframe"
+ "  width=1200 height=900 style=border:0 loading=lazy allowfullscreen referrerpolicy=\"no-referrer-when-downgrade\""
+ "src=\"https://www.google.com/maps/embed/v1/place?key=" + APIKey + "&q=space needle&zoom=18&maptype=satellite\""
+ "</iframe>";

  File f= new File ("KeyTest.html");
  try {
     BufferedWriter bw = new BufferedWriter(new FileWriter(f));
     bw.write(html);
     bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
 }

 public static void runHTML() throws IOException{
   String url = "KeyTest.html";   // keyTest.html is in your project folder
   File htmlFile = new File(url);
   Desktop.getDesktop().browse(htmlFile.toURI());
 }
}
