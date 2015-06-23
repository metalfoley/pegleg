package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;

public class Filo {

	private static String filePath;
	private static File logFile;
	private static File dir;
	private static String fileName;
	private Filo()
	{
		
	}
	

	public static void log(String s)
	{
		PrintWriter pw = null;
		try
		{
						
			LocalDateTime dt = LocalDateTime.now();
			//M-dd-YYYY
			String fileName = dt.getMonthValue() + "-" + dt.getDayOfMonth() + "-" + dt.getYear() + ".txt";
			

			dir = new File("C:\\Utils\\Logs");
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			
			filePath = dir + "\\" + fileName;
			logFile = new File(filePath);
			
			pw = new PrintWriter(new FileWriter(filePath, true), true);		
			pw.println(dt.getHour() + ":" + dt.getMinute() + ":" + dt.getSecond() + " - " + s);

			pw.close();
		}
		catch(IOException e)
		{
			Filo.log("Filo.log: " + e.getMessage());
			
		}
		finally{
			if(pw != null)
			{
				pw.close();
			}
		}
	}
}