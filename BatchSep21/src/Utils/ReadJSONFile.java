package Utils;

import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ReadJSONFile {
	
	String path = "src\\Sample.json";
	
	void jsonRead() {
		
		JsonParser parser = new JsonParser();
		try {
			FileReader reader = new FileReader(path);
			Object obj = parser.parse(reader);
			JsonArray array = (JsonArray) obj;
			System.out.println(array);
			for(int i=0; i<array.size(); i++) {
				System.out.println(array);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
