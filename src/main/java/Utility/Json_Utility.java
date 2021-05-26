package Utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json_Utility {
	static String strBrowserJsonPath = "drivers/browser.json";

	@SuppressWarnings("unchecked")
	public static void writeJson(String strBrowser, String strURL, String strSession) throws IOException {
		JSONObject browserDetails = new JSONObject();
		browserDetails.put("Browser", strBrowser);
		browserDetails.put("URL", strURL);
		browserDetails.put("Session", strSession);
		@SuppressWarnings("resource")
		FileWriter file = new FileWriter(strBrowserJsonPath);
		file.write(browserDetails.toJSONString());
		file.flush();
	}

	public static String[] readJson() throws IOException, ParseException {
		FileReader reader = new FileReader(strBrowserJsonPath);
		Object obj = new JSONParser().parse(reader);
		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;
		// getting firstName and lastName
		String[] returnStr = new String[3];
		returnStr[0] = (String) jo.get("Browser");
		returnStr[1] = (String) jo.get("URL");
		returnStr[2] = (String) jo.get("Session");
		return returnStr;
	}

	public static void deleteJsonFile() {
		File myObj = new File(strBrowserJsonPath);
		if (myObj.delete()) {
			System.out.println("Json file deleted: " + strBrowserJsonPath);
		} else {
			System.out.println("Json file not deleted: " + strBrowserJsonPath);
		}
	}
}