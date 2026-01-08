package api.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class readJsonFile {
 public static JSONObject userJsonFile(String filename) throws FileNotFoundException {
	 File fe = new File(filename);
		FileReader fr = new FileReader(fe);
		JSONTokener jtr = new JSONTokener(fr);
		JSONObject authData = new JSONObject(jtr);
	 return authData;
 }
}
