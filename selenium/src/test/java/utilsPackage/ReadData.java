package utilsPackage;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReadData {
	public String read(String attribute) {
		String name = null;
		String currentDir = System.getProperty("user.dir");
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(currentDir + "/resorces/TestData.json"));
			JSONObject jsonObject = (JSONObject) obj;
			name = (String) jsonObject.get(attribute);
//			String course = (String) jsonObject.get("Course");
//			JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
			System.out.println("Name: " + name);
//			System.out.println("Course: " + course);
//			System.out.println("Subjects:");
//			Iterator iterator = subjects.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;

	}
}