package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyUtilities {
	

	             public static String getJSessionID() {
	                    String id ="";
	                    try {

	                          String url = "https://prowand.pro-unlimited.com/login.html";

	                          URL obj = new URL(url);
	                          HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	                          Map<String, List<String>> map = con.getHeaderFields();   
	                          List<String> setcookie = map.get("Set-Cookie");
	                          String one = setcookie.get(0);
	                          String[] spt = one.split(";");
	                          String result = spt[0];
	                          String[] sessionid = result.split("=");
	                          id = sessionid[1];

	                          System.out.println(id);

	                    } catch (Exception e) {
	                          e.printStackTrace();
	                    }
	                    return id;
	                    }

	            
	             public void createCSVFile(String dateToday, String acnemail, String tower,String req,String wbs, String month, String midperiod, String endperiod, String mytetotal,String wandTotal,String wandProcessed, String status, String csvpath) throws FileNotFoundException {

	                    try {

		                    String filepath = csvpath;
		                    FileWriter fos = new FileWriter(filepath,true);
		                    BufferedWriter bw = new BufferedWriter(fos);
		                    PrintWriter pw = new PrintWriter(bw);
	
		                    pw.println("Date Checked,Email,Tower,Requisition ID,WBS,Month,MyTE 15th,MyTE 30th,MyTE Total,Wand Saved Total,Wand Processed Total,Status");
		                    pw.println(""+dateToday+","+acnemail+","+tower+","+req+","+wbs+","+month+","+midperiod+","+endperiod+","+mytetotal+","+wandTotal+","+wandProcessed+","+status+"");
		                    pw.flush();
		                    pw.close();

	             }catch(Exception e) {
	                    e.printStackTrace();
	             }
	                    return;
	             }


	             public String getTime() {

	                    String dateTime ="";

	                    try {
	
		                    DateFormat dateFormat = new SimpleDateFormat("MMdd");
		                    Date date = new Date();
		                    dateTime = dateFormat.format(date);

			             }catch (Exception e) {
			                    e.printStackTrace();
			             }
			             return dateTime;
			       }

	            
	             public String getDate() {

	                    String dateTime ="";

	                    try {
			                    DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yy");
			                    Date date = new Date();
			                    dateTime = dateFormat.format(date);
		
			             }catch (Exception e) {
			                    e.printStackTrace();
			             }
			             return dateTime;
	             }

	            

	             public void createFile(String filename, String getWandEmail, String getMyTEEmail, String enteredpath) throws IOException {
	                    File file = new File(filename);
	                    file.createNewFile();
	                    FileWriter mywriter = new FileWriter(filename);
	                    BufferedWriter out = new BufferedWriter(mywriter);
	                    out.write(getWandEmail);
	                    out.newLine();
	                    out.write(getMyTEEmail);
	                    out.newLine();
	                    out.write(enteredpath);
	                    out.close();
	             }

}
